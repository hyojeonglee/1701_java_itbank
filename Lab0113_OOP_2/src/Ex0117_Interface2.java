// <클래스 간의 관계>
// 상속 vs 포함
// 클래스의 관계 (주종 관계)
// 클래스 사용자(user) vs 클래스 제공자(provider)

// class A {}
// class B {}
// 이 때, 클래스 A가 B를 사용한다는 것은 다음 세 가지 경우일 수 있다.
//	- A가 B를 상속한다.
//	- A가 B를 멤버필드로 가진다.
//	- A가 B를 method parameter로 가질 수 있다.

// <관계의 분류>
// 	1) 직접적인 관계 (UML의 Dependency) > 현대에는 비추
//		- 왜? 서로의 관계가 너무 끈끈해짐... B 클래스 없어지면 A도 영향 받음
class A {
	void amethod(B b) {
		b.bmethod();
	}
}
class B {
	void bmethod() {
		System.out.println("B 클래스 메소드");
	}
}

//	2) 간접적인 관계 : Interface를 통한 간접 프로그래밍!
//		- C가 D를 사용할 때, D의 메소드를 직접 사용하는 것이 아니라
//		  D에게 추상메소드를 제공하는 인터페이스를 만들어서 간접 제공!
//		- 장점 : C의 cmethod()가 더 유연해진다!
//				Iusable 인터페이스를 상속받는 클래스라면 저 메소드의 파라미터로
//				들어 갈 수 있다.
interface Iusable {
	void method();
}
class C {
	void cmethod(Iusable usable) {
		usable.method();
	}
}
class D implements Iusable {
	@Override
	public void method() {
		System.out.println("D 클래스의 메소드 입니다.");
	}
}
class F implements Iusable {
	@Override
	public void method() {
		System.out.println("F 클래스의 메소드 입니다.");
	}
}




public class Ex0117_Interface2 {
	public static void main(String[] args) {
		// 직접적인 관계
		A a = new A();
		B b = new B();
		a.amethod(b);
		
		// 간접적인 관계
		C c = new C();
		D d = new D();
		F f = new F();
		c.cmethod(d);
		c.cmethod(f);
	}
}

// <Ŭ���� ���� ����>
// ��� vs ����
// Ŭ������ ���� (���� ����)
// Ŭ���� �����(user) vs Ŭ���� ������(provider)

// class A {}
// class B {}
// �� ��, Ŭ���� A�� B�� ����Ѵٴ� ���� ���� �� ���� ����� �� �ִ�.
//	- A�� B�� ����Ѵ�.
//	- A�� B�� ����ʵ�� ������.
//	- A�� B�� method parameter�� ���� �� �ִ�.

// <������ �з�>
// 	1) �������� ���� (UML�� Dependency) > ���뿡�� ����
//		- ��? ������ ���谡 �ʹ� ��������... B Ŭ���� �������� A�� ���� ����
class A {
	void amethod(B b) {
		b.bmethod();
	}
}
class B {
	void bmethod() {
		System.out.println("B Ŭ���� �޼ҵ�");
	}
}

//	2) �������� ���� : Interface�� ���� ���� ���α׷���!
//		- C�� D�� ����� ��, D�� �޼ҵ带 ���� ����ϴ� ���� �ƴ϶�
//		  D���� �߻�޼ҵ带 �����ϴ� �������̽��� ���� ���� ����!
//		- ���� : C�� cmethod()�� �� ����������!
//				Iusable �������̽��� ��ӹ޴� Ŭ������� �� �޼ҵ��� �Ķ���ͷ�
//				��� �� �� �ִ�.
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
		System.out.println("D Ŭ������ �޼ҵ� �Դϴ�.");
	}
}
class F implements Iusable {
	@Override
	public void method() {
		System.out.println("F Ŭ������ �޼ҵ� �Դϴ�.");
	}
}




public class Ex0117_Interface2 {
	public static void main(String[] args) {
		// �������� ����
		A a = new A();
		B b = new B();
		a.amethod(b);
		
		// �������� ����
		C c = new C();
		D d = new D();
		F f = new F();
		c.cmethod(d);
		c.cmethod(f);
	}
}

// 상수 : 한 번 값이 정해지면 변경이 안 된다.
// java : final int NUM = 1000;
// C# : const int NUM = 1000;

// <final 키워드>
// final class FinalClass {} : 상속할 수 없는 클래스
// final method() : 상속 관계에서 재정의(오버라이딩) 금지!

class Vcard {
	final String KIND = "heart"; // 상수
	final int NUM = 100; 
}
//이 때, 객체마다 다른 상수값을 가지길 원한다면? ***
class Vcard2 {
	final String KIND;
	final int NUM;
	// final String KIND; 이렇게 해볼까? 상수는 반드시 초기화 해야되니까 불가능! ***
	// 상수가 객체화 될 때, 다른 값을 가지기 위해서는~
//	public Vcard2() {
//		// this.KIND = "heart"; 얘도 의미 없다! ***
//	}
	// ***답!
	public Vcard2(String KIND, int NUM) {
		this.KIND = KIND;
		this.NUM = NUM;
	}
	// ***주의 : 이 때, 디폴트 생성자는 살리면 안 된다!
}
public class Ex0116_Final {
	public static void main(String[] args) {
		Vcard v = new Vcard();
		// v.KIND = "aaa"; 불가능!
		
	}
}

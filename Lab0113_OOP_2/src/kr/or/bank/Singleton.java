package kr.or.bank;

public class Singleton {
	private static Singleton p = new Singleton();
	
	private Singleton() {} // 객체 생성을 막아준다.
	// static 객체변수 p를 이용할 것이므로 함수도 static이다. 
	public static Singleton getInstance() { // 객체 반환!
		if(p == null)
			p = new Singleton(); // 방어적 코드
		return p;
	}
}

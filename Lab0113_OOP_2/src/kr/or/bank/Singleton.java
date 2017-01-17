package kr.or.bank;
//[디자인 패턴 - 싱글톤 패턴]
//	[유래]
//	class Test {
//		private Test() {
//		}
//		
//		Test 생성 코드와 주소값을 돌려주는 코드를 만든다!
//		객체 안 만들고 접근할 함수는 static 밖에 없다.
//	}
//	
//	main
//	
//	Test t = new Test(); => 이렇게 객체를 무한정 생성하는 것이 마음에 안듦
//	그래서 이런 식으로 객체를 생성하도록 하고 싶음!
//	Test t2 = t;
//	Test t3 = t;
//	
//	Q. 이거 대신 Test 클래스의 객체를 못 만들게 하고 싶으면 어떻게 해야할까?
//	A. 생성자에 private을 붙여준다!

// [특성]
// 1. 여러개의 객체를 생성하더라도 단 하나의 주소(힙에 위치)만 참조 (객체는 딱 하나만 만든다.)
// 2. 한 개의 객체를 같이 사용하려고
// 3. 한 개의 객체만 사용해서 유지보수 편리성을 가지려고

// [어디에 써먹나?]
// 1. JDBC(Java랑 DB(oracle, mySQL) 연결)
//		- 드라이버 로딩(소프트웨어에 필요한 드라이버!)
//		- 드라이버를 한 번 올려두고 필요할 때마다 계속 쓰면 됨 (공통자원) > 싱글톤 패턴 사용!
//		- 주의 : 어떤 작업이 싱글톤 close 해버리면 싱글톤 쓰고있던 나머지 작업도 close 되어버림
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
// DB Connection 예제 using Singleton Pattern

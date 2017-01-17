package kr.or.bank;
// <추상 클래스>
// 왜 쓰는가? 추상자원의 강제적 구현! (설계자 입장)
// 미완성 설계도 : 완성된 코드 + 미완성 코드(실행 블록이 없는 함수)

abstract class abClass {
	abstract void run();
	void stop() { System.out.println("실행 블록"); }
}

class Test extends abClass {
	@Override
	void run() {
		
	}
}

public class Ex0116_Abstract {
	
}

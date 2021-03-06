class StaticM {
	int iv;
	static int cv;
	
	void m() {
		cv = 1000; // 일반 함수에서 static 자원 접근 가능
	}
	
	static void sm() { // 끼리끼리 처리하면 문제 없음~
		// iv = 100; static 함수에서 일반 자원 접근 불가
	}
}

//Q. static 함수의 의도? 객체 선언하지 않아도 사용할 수 있다. 많이 사용하는 자원일 경우!
public class Ex0113_Static_Method {
	public void callMethod() {
		
	}
	
	public static void callSMethod() {
		
	}
	
	public static void main(String[] args) {
		int c = StaticM.cv;
		StaticM.sm();
		
		// case 1. not static
		Ex0113_Static_Method s = new Ex0113_Static_Method();
		s.callMethod();
		
		// case 2. static
		Ex0113_Static_Method.callSMethod();
	}
}

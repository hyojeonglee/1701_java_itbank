// <메소드 예외 던지기>
class Test {
	void call() throws Exception, ArithmeticException, IndexOutOfBoundsException {
		// 무슨 에러가 날지 잘 모르겠는 경우
		System.out.println("Call 함수 start");
		int i = 1 / 0;
		System.out.println("Call 함수 End");
	}
}

public class Ex0117_Exception3 {
	public static void main(String[] args) {
		Test t = new Test();
		// t.call(); 밑줄이 그어지면서 예외처리를 하라고 한다.
		try {
			t.call();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

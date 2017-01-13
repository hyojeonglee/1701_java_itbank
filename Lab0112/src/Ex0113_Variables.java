import kr.or.bank.Car;

public class Ex0113_Variables {
	public static void main(String [] args) {
		String str = "홍길동";
		// 실제로 클래스이다! 사용 시에는 일반 타입처럼 사용하고 heap 영역에 적재!
		// cf. static => stack 영역에 적재!
		String s = "A";
		s += "B";
		s += "C";
		System.out.println(s);
		
		System.out.println("홍\"길\"동"); // 기호 출력할 때는 \ 사용!
		System.out.println("100" + 100); // 100100
		System.out.println(100 + "100");
		System.out.println(100 + 100 + "100");
		System.out.println(100 + "100" + 100);
		
		Car c = new Car(); // 클래스도 타입이다! (메모리에 올리려면 new 연산자 사용)
		System.out.println(c.hashCode());
		Car c2 = new Car();
		System.out.println(c.hashCode());
		System.out.println(c.equals(c2)); // instanceOf()도 잘 사용!
	}
}

import kr.or.bank.Car;

public class Ex0113_Variables {
	public static void main(String [] args) {
		String str = "홍길동";
		// 실제로 클래스이다! 사용 시에는 일반 타입처럼 사용하고 heap 영역에 적재!
		// cf. static => stack 영역에 적재!
		String s  = "A"; // str -->A
		s += "B"; // str-->AB(새로운 메모리 생성하고 그 값 가르킴)
		s += "C"; // str-->ABC 따라서 문자열 누적하는 것은 String 쓰면 메모리 누적 수만큼 사용하기 때문에 성능 안좋아짐. 이럴땐 string builder 써라
		s = "A"; // 새로운 메모리 생성이 아닌, 원래 있던 메모리 A다시 가르킴   
		System.out.println(s);
	      
		char c = '가';

		
		System.out.println("홍\"길\"동"); // 기호 출력할 때는 \ 사용!
		System.out.println("100" + 100); // 100100
		System.out.println(100 + "100");
		System.out.println(100 + 100 + "100");
		System.out.println(100 + "100" + 100);
		
		Car c1 = new Car(); // 클래스도 타입이다! (메모리에 올리려면 new 연산자 사용)
		System.out.println(c1.hashCode());
		Car c2 = new Car();
		System.out.println(c1.hashCode());
		System.out.println(c1.equals(c2)); // instanceOf()도 잘 사용!
	}
}

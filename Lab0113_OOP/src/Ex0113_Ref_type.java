import kr.or.bank.Emp;
import kr.or.bank.AirPlane;

// 클래스 변수는 초기화 안해도 되지만, 지역변수는 초기화 필수
public class Ex0113_Ref_type {
	public static void main(String[] args) {
		Emp e = new Emp(1000, "이효정", "01022224545");
		e.empPrint();
		
		// 문제
		AirPlane a1 = new AirPlane("제주도","120");
		AirPlane a2 = new AirPlane("세부","125");
		AirPlane a3 = new AirPlane("홍콩","130");
		
		a1.printAirPlane();
		a1.printAllNum();
	}
}

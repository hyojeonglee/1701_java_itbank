import kr.or.bank.Emp; // *는 안 쓰는 것이 낫다.

public class Test {
	public static void main(String[] args) {
		// main : initial point of program!
		// 프로그램이 시작하면 포인터가 제일 처음 이곳으로 간다.
		// ctrl+shift+/ : 주석 처리
		// ctrl+shift+\ : 주석 취소
		// ctrl+F11 : 실행 (javac 컴파일 > java 실행)
		/*for (int i = 2 ; i < 10 ; i++) {
			System.out.println(i + "단");
			for (int j = 1 ; j < 10 ; j++) {
				System.out.println(i + " x " + j + " = " + i*j);
			}
		}*/
		// import 안하는 경우 : kr.or.bank.Emp e = kr.or.bank.Emp();
		Emp e = new Emp();
		e.setAge(100);
		System.out.println("Age : " + e.getAge());
		// e. 했을 때 보이는 함수들은 Object의 함수들이다. = 모든 프로젝트는 Object 클래스를 디폴트로 상속받는다.
		// 그 함수들은 최소한 private은 아니다.
		
		e.setEname("이효정");
		System.out.println("Name : " + e.getEname());
		System.out.println("Job : " + e.getJob());
		
		Emp e2 = new Emp("학생");
	}

}
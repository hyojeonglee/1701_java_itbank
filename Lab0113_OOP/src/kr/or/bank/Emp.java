package kr.or.bank;

// 설계도
// 기본 구조 + (속성,상태=변수 + 기능=함수)
public class Emp {
	private int empNo; // 객체변수(멤버변수)
	private String ename;
	private String tel;
	
	// 생성자를 오버로딩해서 쓰면 디폴트생성자를 따로 사용하기 위해서는 명시해주어야한다.
	// 아래처럼 오버로딩한다면 객체 생성시 반드시 정보를 입력하라는 의도가 숨어있음!
	public Emp(int empNo, String ename, String tel) {
		this.empNo = empNo;
		this.ename = ename;
		this.tel = tel;
	}
	public void empPrint() {
		System.out.printf("사번 : %d / 이름 : %s / 전화번호 : %s 입니다.\n",
				this.empNo, this.ename, this.tel);
	}
}

package kr.or.bank;

// Emp 설계도
public class Emp {
	private String ename;
	private int age;
	private String job;
	//private String job = "강사"; // 이렇게 쓰는 것보다 ***
	
	// Constructor(생성자) : 생성자도 함수이다.
	// 목적 : 멤버 필드들을 초기화
	// 실행 시점 : 객체 생성과 동시에 실행
	public Emp() { // 파라미터가 없는 디폴트 생성자
		System.out.println("default");
	}
	
	public Emp(String job) { // 이렇게 생성자로 초기화하는 것이 바람직! ***
		this.job = job;
	}
	
	public String getEname() {
		return ename;
	}
	
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int age) {
		// 조건 추가
		if(age > 0)
			this.age = age;
		else
			this.age = 0;
	}
	
	public String getJob() {
		return job;
	}

	@Override
	public String toString() {
		return "Emp [ename=" + ename + ", age=" + age + ", job=" + job + "]";
	}
	
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		// return super.toString();
//		return "Overriding";
//	}
}
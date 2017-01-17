package kr.or.bank;

public class Emp {
	private int empNo;
	private String name;
	private String job;
	
	public Emp(int empNo, String name, String job) {
		super();
		this.empNo = empNo;
		this.name = name;
		this.job = job;
	}

	public int getEmpNo() {
		return empNo;
	}
	
	public String getName() {
		return name;
	}
	
	public String getJob() {
		return job;
	}
	
	@Override
	public String toString() {
		return "Emp [empNo=" + empNo + ", name=" + name + ", job=" + job + "]";
	}
}

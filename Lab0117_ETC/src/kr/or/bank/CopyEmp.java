package kr.or.bank;

public class CopyEmp {
	private int empNo;
	private String name;
	private int sal;
	
	public CopyEmp(int empNo, String name, int sal) {
		super();
		this.empNo = empNo;
		this.name = name;
		this.sal = sal;
	}

	public int getEmpNo() {
		return empNo;
	}

	public String getName() {
		return name;
	}

	public int getSal() {
		return sal;
	}
	
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "Emp [empNo=" + empNo + ", name=" + name + ", sal=" + sal + "]";
	}
}
package kr.or.bank;

// Emp ���赵
public class Emp {
	private String ename;
	private int age;
	private String job;
	//private String job = "����"; // �̷��� ���� �ͺ��� ***
	
	// Constructor(������) : �����ڵ� �Լ��̴�.
	// ���� : ��� �ʵ���� �ʱ�ȭ
	// ���� ���� : ��ü ������ ���ÿ� ����
	public Emp() { // �Ķ���Ͱ� ���� ����Ʈ ������
		System.out.println("default");
	}
	
	public Emp(String job) { // �̷��� �����ڷ� �ʱ�ȭ�ϴ� ���� �ٶ���! ***
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
		// ���� �߰�
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
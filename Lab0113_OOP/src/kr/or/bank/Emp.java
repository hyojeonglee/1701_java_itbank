package kr.or.bank;

// ���赵
// �⺻ ���� + (�Ӽ�,����=���� + ���=�Լ�)
public class Emp {
	private int empNo; // ��ü����(�������)
	private String ename;
	private String tel;
	
	// �����ڸ� �����ε��ؼ� ���� ����Ʈ�����ڸ� ���� ����ϱ� ���ؼ��� ������־���Ѵ�.
	// �Ʒ�ó�� �����ε��Ѵٸ� ��ü ������ �ݵ�� ������ �Է��϶�� �ǵ��� ��������!
	public Emp(int empNo, String ename, String tel) {
		this.empNo = empNo;
		this.ename = ename;
		this.tel = tel;
	}
	public void empPrint() {
		System.out.printf("��� : %d / �̸� : %s / ��ȭ��ȣ : %s �Դϴ�.\n",
				this.empNo, this.ename, this.tel);
	}
}

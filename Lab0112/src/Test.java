import kr.or.bank.Emp; // kr.or.bank.*���ٴ� �̰� ����. *�� �ִ��� ���� ����.

public class Test {
	public static void main(String[] args) {
		// main : initial point of program!
		// ���α׷��� �����ϸ� �����Ͱ� ���� ó�� �̰����� ����.
		// ctrl+shift+/ : �ּ� ó��
		// ctrl+shift+\ : �ּ� ���
		// ctrl+F11 : ���� (javac ������ > java ����)
		/*for (int i = 2 ; i < 10 ; i++) {
			System.out.println(i + "��");
			for (int j = 1 ; j < 10 ; j++) {
				System.out.println(i + " x " + j + " = " + i*j);
			}
		}*/
		
		// import ���ϴ� ��� : kr.or.bank.Emp e = kr.or.bank.Emp();
		Emp e = new Emp();
		e.setAge(100);
		System.out.println("Age : " + e.getAge());
		// e. ���� �� ���̴� �Լ����� Object�� �Լ����̴�. = ��� ������Ʈ�� Object Ŭ������ ����Ʈ�� ��ӹ޴´�.
		// �� �Լ����� �ּ��� private�� �ƴϴ�.
		
		e.setEname("��ȿ��");
		System.out.println("Name : " + e.getEname());
		System.out.println("Job : " + e.getJob());
		
		Emp e2 = new Emp("�л�");
		e2.setAge(18);
		e2.setEname("��ȿ��");
		System.out.println(e2.toString()); // Object Ŭ������ toString()�� ��ü�� �ּҰ��� ������ش�.
		// ��� toString()�� �������̵��ؼ�(������) ��������� ����ϴ� ���ҷ� ���� ����.
	}

}
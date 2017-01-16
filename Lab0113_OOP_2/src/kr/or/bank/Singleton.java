package kr.or.bank;

public class Singleton {
	private static Singleton p = new Singleton();
	
	private Singleton() {} // ��ü ������ �����ش�.
	// static ��ü���� p�� �̿��� ���̹Ƿ� �Լ��� static�̴�. 
	public static Singleton getInstance() { // ��ü ��ȯ!
		if(p == null)
			p = new Singleton(); // ����� �ڵ�
		return p;
	}
}

package kr.or.bank;
// <�߻� Ŭ����>
// �� ���°�? �߻��ڿ��� ������ ����! (������ ����)
// �̿ϼ� ���赵 : �ϼ��� �ڵ� + �̿ϼ� �ڵ�(���� ����� ���� �Լ�)

abstract class abClass {
	abstract void run();
	void stop() { System.out.println("���� ���"); }
}

class Test extends abClass {
	@Override
	void run() {
		
	}
}

public class Ex0116_Abstract {
	
}

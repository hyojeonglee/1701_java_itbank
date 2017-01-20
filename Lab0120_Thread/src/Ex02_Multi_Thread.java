// ����� ���
// - Thread ���
// - Runnable ����

// Thread ���
class Thread_1 extends Thread {

	@Override
	public void run() {
		// Stack �����ǰ� main �Լ�ó�� ó�� ����ȴ�.
		for(int i = 0 ; i < 1000 ; i++) {
			System.out.println("��Thread : " + i + this.getName());
		}
		System.out.println("***********************Thread_1 run �Լ� ������.");
	}
}

// Runnable ���
class Thread_2 implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < 1000 ; i++) {
		System.out.println("Runnable : " + i);
		}
		System.out.println("Runnable end");
	}
}

public class Ex02_Multi_Thread {
	public static void main(String[] args) {
		Thread_1 th = new Thread_1();
		th.start(); // start�� ������ �߿�!
		// 1. ���ο� ���� �޸� ����
		// 2. ������ ���ÿ� run() �÷���
		// 3. ���ÿ��� �����
		// 4. main�� run�� �ִ� ������ �Բ� ���ư�
		
		Thread th2 = new Thread(new Thread_2());
		th2.start(); // �̷��� �ϸ鼭 �� 3���� ������ ����ϰ� ��
		
		for(int i = 0 ; i < 1000 ; i++) {
			System.out.println("*Main : " + i);
		}
		System.out.println("***********************Main Thread ������.");
	}
}

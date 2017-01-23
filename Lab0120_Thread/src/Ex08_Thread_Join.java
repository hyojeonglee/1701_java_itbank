import org.omg.Messaging.SyncScopeHelper;

// join�� ����
// ������ ���, ���� �ο�
// ����� �� �� �ִ�.
// ex) racing game


class Thread_Join extends Thread {
	@Override
	public void run() {
		for(int i = 0 ; i < 3000 ; i++) {
			System.out.println("----------------");
		}
	}
}

class Thread_Join2 extends Thread {
	@Override
	public void run() {
		for(int i = 0 ; i < 3000 ; i++) {
			System.out.println("|||||||||");
		}
	}
}

public class Ex08_Thread_Join {
	public static void main(String[] args) {
		Thread_Join th = new Thread_Join();
		Thread_Join2 th2 = new Thread_Join2();
		
		th.start();
		th2.start();
		
		long startTime = System.currentTimeMillis();
		try {
			// main �����尡 join ��û�� ����
			// main��. �� ��ٸ��ž� th, th2 �۾��� ���� �� ����!
			th.join();
			th2.join();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		for(int i = 0 ; i < 3000 ; i++) {
			System.out.println("^^^^^^^");
		}
		System.out.println("3���� �����尡 ����� �� �ð�");
		System.out.println(System.currentTimeMillis() - startTime);
	}
}

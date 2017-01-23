import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// �۾�
class Task implements Runnable {
	private String name;
	
	public Task(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Thread ID = " + Thread.currentThread().getName()
				+ "name : " + name + " Start!");
		try {
			Thread.sleep(1000);
		} catch(Exception e) {
		}
		System.out.println("Thread ID = " + Thread.currentThread().getName()
				+ "name : " + name + " End!");
	}
}

public class Ex16_ThreadPool {
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(2);
		// ������Ǯ�� 2���� ��� ������ ���ÿ� ������ �� ���� �������� �ʰ�
		// ������ 2������ �����Ѵ� > ȿ����!
		// �� ��, ������Ǯ�� 3���� ������ �� ���� ���ÿ� �����Ѵ�.
		
		int i = 0;
		for(i = 0 ; i < 3 ; i++) { // �����带 3���� �����.
			service.execute(new Task("Task : " + i));
		}
		service.shutdown(); // �� �̻� ������ ��û�� ���� �ʰ� �ݱ� ���
//		while(!service.isTerminated()) {
//			
//		}
		//System.out.println("Complete All Task!");
	}
}

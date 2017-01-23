import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 작업
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
		// 스레드풀을 2개를 잡고 돌리면 동시에 스레드 세 개가 시작하지 않고
		// 스레드 2개부터 시작한다 > 효율적!
		// 이 때, 스레드풀을 3개로 잡으면 세 개가 동시에 시작한다.
		
		int i = 0;
		for(i = 0 ; i < 3 ; i++) { // 스레드를 3개를 만든다.
			service.execute(new Task("Task : " + i));
		}
		service.shutdown(); // 더 이상 스레드 요청을 받지 않고 닫기 기능
//		while(!service.isTerminated()) {
//			
//		}
		//System.out.println("Complete All Task!");
	}
}

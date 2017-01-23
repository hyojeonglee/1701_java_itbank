import org.omg.Messaging.SyncScopeHelper;

// join의 역할
// 복잡한 계산, 순위 부여
// 결과도 알 수 있다.
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
			// main 스레드가 join 요청을 보냄
			// main왈. 나 기다릴거야 th, th2 작업이 끝날 때 까지!
			th.join();
			th2.join();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		for(int i = 0 ; i < 3000 ; i++) {
			System.out.println("^^^^^^^");
		}
		System.out.println("3개의 스레드가 실행된 총 시간");
		System.out.println(System.currentTimeMillis() - startTime);
	}
}

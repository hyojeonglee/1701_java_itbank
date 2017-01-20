// 만드는 방법
// - Thread 상속
// - Runnable 구현

// Thread 사용
class Thread_1 extends Thread {

	@Override
	public void run() {
		// Stack 생성되고 main 함수처럼 처음 실행된다.
		for(int i = 0 ; i < 1000 ; i++) {
			System.out.println("★Thread : " + i + this.getName());
		}
		System.out.println("***********************Thread_1 run 함수 끝났다.");
	}
}

// Runnable 사용
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
		th.start(); // start의 역할이 중요!
		// 1. 새로운 스택 메모리 생성
		// 2. 생성된 스택에 run() 올려줌
		// 3. 스택에서 사라짐
		// 4. main과 run이 있는 스택이 함께 돌아감
		
		Thread th2 = new Thread(new Thread_2());
		th2.start(); // 이렇게 하면서 총 3개의 스레드 사용하게 됨
		
		for(int i = 0 ; i < 1000 ; i++) {
			System.out.println("*Main : " + i);
		}
		System.out.println("***********************Main Thread 끝났다.");
	}
}

// Thread 우선순위
// Default = 5 (Max 10, Min 1)

class Pth extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < 1000 ; i++) {
			System.out.println("------");
		}
	}
	
	
}

class Pth2 extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < 1000 ; i++) {
			System.out.println("|||||||");
		}
	}
	
}

public class Ex06_Priority {
	public static void main(String[] args) {
		Pth th = new Pth();
		Pth2 th2 = new Pth2();
		System.out.println("before : " + th.getPriority());
		th.setPriority(10);
		th.setPriority(1);
		System.out.println("after : " + th.getPriority());
		System.out.println("after : " + th2.getPriority());
		
		th.start();
		th2.start();
		System.out.println("Main End");
	}
}

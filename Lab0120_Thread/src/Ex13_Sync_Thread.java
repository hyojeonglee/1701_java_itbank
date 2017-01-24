//Thread 간에 공유

class Runableimple implements Runnable{
	int iv = 0; //member field(instance variable)
	@Override
	public void run() {
		int lv = 0; //local variable
		String name = Thread.currentThread().getName(); // Thread_1 
		while(lv < 3){
			System.out.println(name + "local var : " + ++lv);
			System.out.println(name + "instance var : " + ++iv);
			System.out.println();
		}
		
	}
	
}
public class Ex13_Sync_Thread {
	public static void main(String[] args) {
		/*
		Runableimple r = new Runableimple();
		Runableimple r2 = new Runableimple();

		Thread th = new Thread(r);
		Thread th2 = new Thread(r2);
		th.start();
		th2.start();
		*/
		Runableimple r = new Runableimple();
		Thread th = new Thread(r);
		Thread th2 = new Thread(r);
		th.start();
		th2.start();
		
	}

}







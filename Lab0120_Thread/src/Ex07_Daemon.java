// 보조 스레드! 데몬 스레드

public class Ex07_Daemon implements Runnable {
	static boolean autosave = false;
	
	public static void main(String[] args) {
		Thread th = new Thread(new Ex07_Daemon());
		th.setDaemon(true); // start 하기 전에 반드시 해준다! main 함수 스레드의 보조!
		th.start();
		
		//
		for(int i = 0 ; i <= 30 ; i++) {
			try { 
				Thread.sleep(1000);
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.println("Main Thread : " + i);
			if(i == 5) {
				autosave = true;
			}
		}
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(3000);
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
			// 조건
			if(autosave) {
				AutoSave();
			}
		}
	}
	
	public void AutoSave() {
		System.out.println("문서가 자동 저장 되었습니다.");
	}
	
}

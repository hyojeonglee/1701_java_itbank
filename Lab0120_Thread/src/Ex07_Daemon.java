// ���� ������! ���� ������

public class Ex07_Daemon implements Runnable {
	static boolean autosave = false;
	
	public static void main(String[] args) {
		Thread th = new Thread(new Ex07_Daemon());
		th.setDaemon(true); // start �ϱ� ���� �ݵ�� ���ش�! main �Լ� �������� ����!
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
			// ����
			if(autosave) {
				AutoSave();
			}
		}
	}
	
	public void AutoSave() {
		System.out.println("������ �ڵ� ���� �Ǿ����ϴ�.");
	}
	
}

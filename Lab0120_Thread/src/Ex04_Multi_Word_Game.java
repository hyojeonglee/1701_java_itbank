import javax.swing.JOptionPane;

class WordTime extends Thread {

	@Override
	public void run() {
		for(int i = 10 ; i > 0 ; i--) {
			System.out.println("���� �ð�" + i);
			try {
				Thread.sleep(2000);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}

public class Ex04_Multi_Word_Game {
	public static void main(String[] args) {
		WordTime timer = new WordTime();
		timer.start();
		String inputData = JOptionPane.showInputDialog("���� �Է��ϼ���");
		System.out.println("����� �Է��� ���� : " + inputData);
	}
}

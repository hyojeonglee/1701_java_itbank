import javax.swing.JOptionPane;

class WordTime extends Thread {

	@Override
	public void run() {
		for(int i = 10 ; i > 0 ; i--) {
			System.out.println("남은 시간" + i);
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
		String inputData = JOptionPane.showInputDialog("값을 입력하세요");
		System.out.println("당신이 입력한 값은 : " + inputData);
	}
}

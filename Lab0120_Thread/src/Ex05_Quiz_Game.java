import java.util.Random;
import javax.swing.JOptionPane;

// ���� : �ƹ��ų�! (������, �ܾ�)
// �Է��� �ް�
// �Է� �ð��� ������ ������ ����Ǿ���Ѵ�.

class Timer extends Thread {
	final int TIME = 1000;
	final int ITER = 10;
	
	@Override
	public void run() {
		for(int i = ITER ; i > 0 ; i--) {
			try {
				System.out.println("���� �ð� : " + i);
				Thread.sleep(TIME);
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("�ð��ʰ�~");
		System.out.println("***���� ������ " + Ex05_Quiz_Game.correctNum + "���Դϴ�.");
		System.exit(0);
	}
}

public class Ex05_Quiz_Game {
	public static int correctNum = 0;
	
	public static void main(String[] args) {
		Random r = new Random();
		Timer timer = new Timer();
		
		timer.start();
		while(true) {
			int op1 = r.nextInt(9) + 1;
			int op2 = r.nextInt(9) + 1;
			int realAnswer = op1 * op2;
			
			String inputData = JOptionPane.showInputDialog(op1 + " X " + op2 + "= ?");
			if(inputData != null) {
				int userAnswer = Integer.valueOf(inputData);
				
				if(userAnswer != realAnswer) {
					System.out.println("***�����Դϴ�! ���� ������ " + correctNum + "���Դϴ�.");
					System.out.println("- ����� �Է��� ���� : " + userAnswer);
					System.out.println("- ������ : " + realAnswer);
					System.exit(0);
				}
				else
					correctNum++;
			}
		}
	}
}

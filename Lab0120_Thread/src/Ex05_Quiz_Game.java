import java.util.Random;
import javax.swing.JOptionPane;

// 게임 : 아무거나! (구구단, 단어)
// 입력을 받고
// 입력 시간이 지나면 게임은 종료되어야한다.

class Timer extends Thread {
	final int TIME = 1000;
	final int ITER = 10;
	
	@Override
	public void run() {
		for(int i = ITER ; i > 0 ; i--) {
			try {
				System.out.println("남은 시간 : " + i);
				Thread.sleep(TIME);
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("시간초과~");
		System.out.println("***맞춘 문제는 " + Ex05_Quiz_Game.correctNum + "개입니다.");
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
					System.out.println("***오답입니다! 맞춘 문제는 " + correctNum + "개입니다.");
					System.out.println("- 당신이 입력한 값은 : " + userAnswer);
					System.out.println("- 정답은 : " + realAnswer);
					System.exit(0);
				}
				else
					correctNum++;
			}
		}
	}
}

import javax.swing.JOptionPane;

// 단어 맞추기 게임
// 1. 단어 입력하는 창
// 2. 일정 시간을 부여해서 게임 종료되도록!

public class Ex03_Single_Word_Game {
	// 싱글스레드로 구현하면?
	public static void main(String[] args) {
		String inputData = JOptionPane.showInputDialog("값을 입력하세요");
		System.out.println("당신이 입력한 값은 : " + inputData);
		CheckTime();
	}
	
	static void CheckTime() {
		for(int i = 10 ; i > 0 ; i--) {
			System.out.println("남은 시간" + i);
			try {
				Thread.sleep(2000);
			} catch(Exception e) {
				
			}
		}
	}
	// 이렇게하면 단어입력창과 시간체크가 동시에 돌아갈까?
	// 그렇지 않다... 저 창이 꺼져야 타이머가 돌아간다.
	// 스레드가 필요함!
}

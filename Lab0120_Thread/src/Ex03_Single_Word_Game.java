import javax.swing.JOptionPane;

// �ܾ� ���߱� ����
// 1. �ܾ� �Է��ϴ� â
// 2. ���� �ð��� �ο��ؼ� ���� ����ǵ���!

public class Ex03_Single_Word_Game {
	// �̱۽������ �����ϸ�?
	public static void main(String[] args) {
		String inputData = JOptionPane.showInputDialog("���� �Է��ϼ���");
		System.out.println("����� �Է��� ���� : " + inputData);
		CheckTime();
	}
	
	static void CheckTime() {
		for(int i = 10 ; i > 0 ; i--) {
			System.out.println("���� �ð�" + i);
			try {
				Thread.sleep(2000);
			} catch(Exception e) {
				
			}
		}
	}
	// �̷����ϸ� �ܾ��Է�â�� �ð�üũ�� ���ÿ� ���ư���?
	// �׷��� �ʴ�... �� â�� ������ Ÿ�̸Ӱ� ���ư���.
	// �����尡 �ʿ���!
}

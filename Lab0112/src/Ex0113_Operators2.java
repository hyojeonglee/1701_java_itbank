import java.util.Random;

public class Ex0113_Operators2 {
	public static void main(String[] args) {
		// ���� 3. ��ǰ ��÷ ���α׷�
		Random r = new Random();
		int score = r.nextInt(10) + 1;
		score *= 100; // ������ 100, 200, ... �̷��� ��������
		String result = "";
		switch(score) {
		case 1000:
			result += "TV ";
		case 900:
			result += "Notebook ";
		case 800:
			result += "����� ";
		case 700:
			result += "�ѿ� ";
		case 600:
			result += "���� ";
		default :
			result += "�縻";
		}
		System.out.println("���� : " + score);
		System.out.println("��� : " + result);
		
		// Point1. ������ ���� > ����
		String str = "123";
		int i = Integer.parseInt(str);
		// Float.parseFloat(str);
		
		// Point2. ���� > ����
		int j = 1000;
		String str2 = String.valueOf(j);
		System.out.println(str2);
	}
}
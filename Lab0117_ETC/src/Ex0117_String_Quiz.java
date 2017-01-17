import java.util.Scanner;

// ����ڷκ��� �ֹ� ��ȣ �Է¹��� ��
// ��ȿ�� ���� : 14�ڸ� (123456-1234567)
// ���� ���� ���� 1, 3 ���� 2, 4 ����

public class Ex0117_String_Quiz {
	public static void main(String[] args) {
		String id = "";
		do {
			Scanner scan = new Scanner(System.in);
			System.out.print("�ֹ� ��ȣ�� �Է����ּ��� : ");
			id = scan.nextLine();
		} while(!idCheck(id) || !idFirstNumber(id));
		idDisplay(id);
	}
	
	static boolean idCheck(String str) {
		return (str.length()==14 && str.charAt(6) == '-') ? true : false;
	}
	
	static boolean idFirstNumber(String str) {
		int number = getFirstNumber(str);
		return (number > 0 && number < 5) ? true : false;
	}
	
	static int getFirstNumber(String str) {
		// int position = str.indexOf('-');
		// int number = Character.getNumericValue(str.charAt(position + 1));
		int number = Integer.parseInt(str.substring(7, 8)); // �� ����!
		return number;
	}
	
	static void idDisplay(String str) {
		// ���� �� ���
		int number = getFirstNumber(str);
		String result = (number % 2 == 0)? "����" : "����";
		System.out.println(result);
		
		// �����
		char cgen = str.replace("-", "").charAt(6);
		switch(cgen) {
		case '1':
		case '3':
			System.out.println("����");
			break;
		case '2':
		case '4':
			System.out.println("����");
			break;
		}
	}
}

import java.util.HashMap;
import java.util.Scanner;

// ȸ�� �α��� ó��

public class Ex0118_Map_apply {
	public static void main(String[] args) {
		HashMap loginMap = new HashMap();
		loginMap.put("kim", "kim1004");
		loginMap.put("scott", "tiger");
		
		// �α��� ���� �ý���
		Scanner scan = new Scanner(System.in);
		while(true){
			System.out.print("id �Է� : ");
			String id = scan.nextLine().trim().toLowerCase(); // ���� ��������, �ҹ���
			System.out.print("password �Է� : ");
			String pwd = scan.nextLine().trim();
			
//			if(loginMap.containsKey(id)) {
//				String tempPwd = (String) loginMap.get(id);
//				if(pwd.equals(tempPwd)) {
//					System.out.println("�α��� ����!");
//				}
//				else
//					System.out.println("��й�ȣ�� Ʋ���ϴ�!");
//			}
//			else {
//				System.out.println("ȸ�� ���̵� �������� �ʽ��ϴ�.");
//			}
			
			// �����
			if(!loginMap.containsKey(id)) {
				System.out.println("���̵� ����� ���Է����ּ���");
				continue;
			}
			else {
				if(loginMap.get(id).equals(pwd)) {
					System.out.println("�α��� ����");
					break;
				}
				else {
					System.out.println("�н����� Ʋ��");
				}
			}
		}
	}
}

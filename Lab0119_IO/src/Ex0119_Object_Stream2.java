import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

// ����
public class Ex0119_Object_Stream2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "UserData.ser";
		// �䷸�� ������ ���� ������, finally ��Ͽ��� ����Ϸ���
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream(fileName);
			bis = new BufferedInputStream(fis);
			// ������ȭ~
			ois = new ObjectInputStream(bis);
			// ���� ���� � �� ��������
			UserInfo r1 = (UserInfo) ois.readObject(); // ����ȯ �ʿ�!
			UserInfo r2 = (UserInfo) ois.readObject();
			
			System.out.println("���Ͽ��� ���� ��ü ������ ���� > " + r1.toString());
			System.out.println("���Ͽ��� ���� ��ü ������ ���� > " + r2.toString());
		} catch(Exception e) {
			
		} finally {
			try {
				ois.close();
				bis.close();
				fis.close();
			} catch(Exception e) {
			}
		}
	}
}

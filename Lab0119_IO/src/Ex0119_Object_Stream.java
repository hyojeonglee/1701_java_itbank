import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Ex0119_Object_Stream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "UserData.ser";
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			// ObjectInputStream ois = new ObjectInputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			
			UserInfo u1 = new UserInfo("superman", "super", 1000);
			UserInfo u2 = new UserInfo("scott", "tiger", 40);
			
			// ����ȭ~
			// ���Ͽ� ��ü�� �� ��
			oos.writeObject(u1);
			oos.writeObject(u2); // ���Ͽ� �ϳ��� �������� �ʳ�
			
			oos.close();
			bos.close();
			fos.close();
			System.out.println("���ϻ��� - ����ȭ - ��ü write");
			
		} catch(Exception e) {
			
		}
	}

}

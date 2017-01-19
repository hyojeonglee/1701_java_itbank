import java.io.FileInputStream;
import java.io.FileOutputStream;

// orifile�� 100bytes�� �о targetfile�� �״�� �ű��.

public class Ex0119_Stream_Image {
	public static void main(String[] args) throws Exception {
		String orifile = "C:\\Temp\\pig.jpg";
		String targetfile = "C:\\Temp\\new.jpg";
		
		FileInputStream fis = new FileInputStream(orifile);
		FileOutputStream fos = new FileOutputStream(targetfile);
		
		int readByteNo;
		byte[] readBytes = new byte[100]; // 100bytes�� �д´�.
		while((readByteNo = fis.read(readBytes)) != -1) {
			System.out.println(readByteNo);
			fos.write(readBytes, 0, readByteNo);
		}
		fos.flush(); // ���� ������ ��
		fos.close();
		fis.close();
		System.out.println("�Ϸ�");
	}
}

import java.io.FileInputStream;
import java.io.FileOutputStream;

// orifile을 100bytes씩 읽어서 targetfile에 그대로 옮긴다.

public class Ex0119_Stream_Image {
	public static void main(String[] args) throws Exception {
		String orifile = "C:\\Temp\\pig.jpg";
		String targetfile = "C:\\Temp\\new.jpg";
		
		FileInputStream fis = new FileInputStream(orifile);
		FileOutputStream fos = new FileOutputStream(targetfile);
		
		int readByteNo;
		byte[] readBytes = new byte[100]; // 100bytes씩 읽는다.
		while((readByteNo = fis.read(readBytes)) != -1) {
			System.out.println(readByteNo);
			fos.write(readBytes, 0, readByteNo);
		}
		fos.flush(); // 버퍼 비워줘야 함
		fos.close();
		fis.close();
		System.out.println("완료");
	}
}

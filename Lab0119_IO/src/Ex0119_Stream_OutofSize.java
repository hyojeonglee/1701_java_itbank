import java.io.FileInputStream;

// 한글 안녕하세요가 깨져버린다. 영어는 제대로 읽는뎅
// 한글 제대로 읽으려면 reader랑 writer 필요함!

public class Ex0119_Stream_OutofSize {
	public static void main(String[] args) {
		FileInputStream input = null;
		try {
			input = new FileInputStream("kor.txt");
			int data = 0;
			while((data = input.read()) != -1) {
				System.out.println(data + ":" + (char)data);
			}
		} catch(Exception e) {
			
		} finally {
			try {
				input.close();
			} catch(Exception e) {
				
			}
		}
	}
}

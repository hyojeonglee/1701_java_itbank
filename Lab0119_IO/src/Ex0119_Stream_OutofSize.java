import java.io.FileInputStream;

// �ѱ� �ȳ��ϼ��䰡 ����������. ����� ����� �дµ�
// �ѱ� ����� �������� reader�� writer �ʿ���!

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

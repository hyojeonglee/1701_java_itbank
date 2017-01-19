import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

// <Buffer>
// WAS���� ���۰� ��ġ�� ���� ��Ʈ������ �ѱ��.

public class Ex0119_Stream_Buffer {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try {
			fos = new FileOutputStream("data.txt"); // File�� �ڵ����� ����
			// ����Ʈ ��δ� ������Ʈ ���� ��! (Lab0119_IO)
			// ���۴� ȥ�� ���� �� ����. ��? ����Ʈ �����ڸ� �� ����� ����! ������ �Ķ���� �ְ� ����
			bos = new BufferedOutputStream(fos); // �䷸��! ���۰� ���ο� fos�� ���ϰ� ��!
			// ���۸� �� �� ��� : �� ����Ʈ�� ���� ����� vs ���۸� ���� �۾� : ���� ��°�� IO! > ȿ����
			for(int i = '1' ; i <= '9' ; i++) {
				bos.write(i); // ���۸� ����, data.txt�� 1~9������ ���ڸ� ����.
			}
			// ������ �⺻���� ũ��� 8KB (8192 bytes)
			// Ư¡ : ������ ������ ä������ ������, �������� �ʴ´�! �� �ڵ� �����ؼ� ���� �����
			// ����ִ�! ����? ***
			// ��� ������ �����ϸ�, flush()��� �� ���۸� ����� ����ε�(��������� ���)
			// bos.flush()�� �ؾ� ���۸� �������� ���Ͽ� ���� ������.(�� ������ �ʴ��� ������ ������)
			// �ؿ� bos.close()�ε� �Ǵµ�? > close() ���ο� flush()�� �ֱ���!
			
			// ex) ���� ������ ó��
			// �� �� 9000bytes¥�� �̹����� ���ۿ� ���������ϸ� �뷮�� ���ļ� ������ �̹����� ������ ���´�.
		} catch(Exception e) {
			
		} finally {
			try {
				bos.close(); // �̷��� �ص� ������! ***
				fos.close();
			} catch(Exception e) {
				
			}
		}
	}
}

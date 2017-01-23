import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;

// �������� �״�� �о����
// ���󿡼� �̹��� �о���� (�� ũ�Ѹ�)

public class Ex02_URLConnection {
	public static void main(String[] args) throws Exception {
		// �� ������ �״��
		// String urlStr = "http://www.kangcom.com/company/history.asp";
		// ���� �̹���
		String urlStr = "http://image3.kangcom.com/2016/11/b_pic/201611251709.jpg";
		URL url = new URL(urlStr);
		
		// �� ����� �ʹ� ����!
//		FileInputStream in = (FileInputStream)url.openStream(); // URL ��ü�� ���������� Stream�� ������.
//		BufferedInputStream bis = new BufferedInputStream(in);
		
		// �����ϰ� �̷��� ����~
		BufferedInputStream bis = new BufferedInputStream(url.openStream());
		// FileOutputStream fos = new FileOutputStream("copy.html");
		FileOutputStream fos = new FileOutputStream("copy.jpg");
		byte[] buffer = new byte[2048];
		int n = 0;
		int count = 0;
		URLConnection uc = url.openConnection();
		int filesize = uc.getContentLength();
		System.out.println("���� ũ�� : " + filesize);
		System.out.println("���� ���� : " + uc.getContentType());
		
		while((n = bis.read(buffer)) != -1) {
			fos.write(buffer, 0, buffer.length);
			fos.flush();
			System.out.println("n : " + n);
			count += n;
		}
		System.out.println(count + "/ ");
		fos.close();
		bis.close();
	}
}

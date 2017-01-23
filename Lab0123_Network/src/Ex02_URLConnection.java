import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;

// 웹페이지 그대로 읽어오기
// 웹상에서 이미지 읽어오기 (웹 크롤링)

public class Ex02_URLConnection {
	public static void main(String[] args) throws Exception {
		// 웹 페이지 그대로
		// String urlStr = "http://www.kangcom.com/company/history.asp";
		// 웹의 이미지
		String urlStr = "http://image3.kangcom.com/2016/11/b_pic/201611251709.jpg";
		URL url = new URL(urlStr);
		
		// 이 방법은 너무 복잡!
//		FileInputStream in = (FileInputStream)url.openStream(); // URL 객체가 내부적으로 Stream을 가진다.
//		BufferedInputStream bis = new BufferedInputStream(in);
		
		// 간단하게 이렇게 쓰자~
		BufferedInputStream bis = new BufferedInputStream(url.openStream());
		// FileOutputStream fos = new FileOutputStream("copy.html");
		FileOutputStream fos = new FileOutputStream("copy.jpg");
		byte[] buffer = new byte[2048];
		int n = 0;
		int count = 0;
		URLConnection uc = url.openConnection();
		int filesize = uc.getContentLength();
		System.out.println("파일 크기 : " + filesize);
		System.out.println("파일 형식 : " + uc.getContentType());
		
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

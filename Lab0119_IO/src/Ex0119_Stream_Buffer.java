import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

// <Buffer>
// WAS에서 버퍼가 넘치면 보조 스트림으로 넘긴다.

public class Ex0119_Stream_Buffer {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try {
			fos = new FileOutputStream("data.txt"); // File을 자동으로 생성
			// 디폴트 경로는 프로젝트 폴더 내! (Lab0119_IO)
			// 버퍼는 혼자 쓰일 수 없다. 왜? 디폴트 생성자를 안 만들어 놓음! 강제로 파라미터 넣게 만듦
			bos = new BufferedOutputStream(fos); // 요렇게! 버퍼가 내부에 fos를 지니게 됨!
			// 버퍼를 안 쓴 경우 : 한 바이트씩 쓰고 지우고 vs 버퍼를 통한 작업 : 버퍼 통째로 IO! > 효율적
			for(int i = '1' ; i <= '9' ; i++) {
				bos.write(i); // 버퍼를 통해, data.txt에 1~9까지의 문자를 쓴다.
			}
			// 버퍼의 기본적인 크기는 8KB (8192 bytes)
			// 특징 : 버퍼의 내용이 채워지지 않으면, 내보내지 않는다! 위 코드 실행해서 문서 열어보면
			// 비어있다! 왜지? ***
			// 사실 엄격히 설명하면, flush()라는 건 버퍼를 비우라는 명령인데(내보내라는 명령)
			// bos.flush()를 해야 버퍼를 내보내서 파일에 글이 써진다.(꽉 차있지 않더라도 강제로 내보냄)
			// 밑에 bos.close()로도 되는데? > close() 내부에 flush()가 있구나!
			
			// ex) 웹의 페이지 처리
			// 이 때 9000bytes짜리 이미지를 버퍼에 담으려고하면 용량이 넘쳐서 나머지 이미지는 깨져서 나온다.
		} catch(Exception e) {
			
		} finally {
			try {
				bos.close(); // 이렇게 해도 써지네! ***
				fos.close();
			} catch(Exception e) {
				
			}
		}
	}
}

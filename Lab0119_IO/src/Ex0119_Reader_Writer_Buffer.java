import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// 버퍼 사용! 라인 단위로 데이터 처리 가능해짐!
// 문제!
// IOEx2.java를 버퍼를 통해 읽는데, 라인 단위로 읽는다.
// 조건 : ;이 있는 문장만 콘솔에 출력(파일로 쓰지말고) 

public class Ex0119_Reader_Writer_Buffer {
	public static void main(String[] args) throws Exception {
		BufferedReader br = null;
		FileReader fr = null;

		try {

			fr = new FileReader("src/IOEx2.java");
			br = new BufferedReader(fr);

			String sCurrentLine;

			br = new BufferedReader(new FileReader("src/IOEx2.java"));

			while ((sCurrentLine = br.readLine()) != null) {
				if(sCurrentLine.length() != 0) {
					if(sCurrentLine.charAt(sCurrentLine.length() - 1) == ';')
						System.out.println(sCurrentLine);
				}
			}
			
//			// 강사님
//			String line = "";
//			for(int i = 0 ; (line = br.readLine()) != null ; i++) {
//				if(line.indexOf(";") != -1) {
//					System.out.println(line);
//				}
//			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
	}
}

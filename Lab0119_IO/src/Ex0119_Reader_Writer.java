import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// 문자 기반 데이터 처리 (2byte 한글, char)

public class Ex0119_Reader_Writer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader("src/IOEx2.java");
			fw = new FileWriter("Copy_Ex01.txt"); // 파일이 없다면 생성해줌
			int data = 0;
			while((data = fr.read()) != -1) {
				System.out.println("read data : " + data + " 변환 : " + (char)data);
				//fw.write(data);
				// 문제!
				// 엔터, 공백, 탭 문자는 write하지말기
				if(data != '\n' && data != '\r' && data != '\t' && data != ' ') {
					fw.write(data);
				}
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				fr.close();
				fw.close();
			} catch (Exception e) {
				
			}
		}
	}

}

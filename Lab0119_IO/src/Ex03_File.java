import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//대상 : File
//File (read , write)
//Fileinputstream
//Fileoutputstream
//대상 : C:\\Temp\\a.txt
public class Ex03_File {

	public static void main(String[] args) {
		//1단계 코드
		/*
		  try {
				FileInputStream fs = new FileInputStream("C:\\Temp\\file.txt");
				int data = 0;
				while((data = fs.read()) != -1){
					System.out.println(data);
					char c = (char)data;
					System.out.println(c);
				}
		} catch (FileNotFoundException e) {
				e.printStackTrace();
		} catch(IOException e){
				e.printStackTrace();
		}
		*/
		FileInputStream fs = null;
		FileOutputStream fos = null;
		String path = "C:\\Temp\\file.txt";
		try{
			fs = new FileInputStream(path);
			//fos = new FileOutputStream("C:\\Temp\\new.txt",true); //append (HelloHelloHello..)
			fos = new FileOutputStream("C:\\Temp\\new.txt"); // 기본 false > overwrite
			int data = 0;
			while((data = fs.read()) != -1){
				fos.write(data); //현재 new.txt 없는 상태
			}
		}catch(Exception e){
			
		}finally {
			//습관적으로 (I/O 자원은 가비지컬렉터의대상 아니다) 개발자가 자원 해제
			try {
				fs.close();
				fos.close(); //명시적인 자원 해제
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}




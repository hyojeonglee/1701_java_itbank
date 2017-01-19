import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//��� : File
//File (read , write)
//Fileinputstream
//Fileoutputstream
//��� : C:\\Temp\\a.txt
public class Ex03_File {

	public static void main(String[] args) {
		//1�ܰ� �ڵ�
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
			fos = new FileOutputStream("C:\\Temp\\new.txt"); // �⺻ false > overwrite
			int data = 0;
			while((data = fs.read()) != -1){
				fos.write(data); //���� new.txt ���� ����
			}
		}catch(Exception e){
			
		}finally {
			//���������� (I/O �ڿ��� �������÷����Ǵ�� �ƴϴ�) �����ڰ� �ڿ� ����
			try {
				fs.close();
				fos.close(); //������� �ڿ� ����
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}




import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// ���� ��� ������ ó�� (2byte �ѱ�, char)

public class Ex0119_Reader_Writer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader("src/IOEx2.java");
			fw = new FileWriter("Copy_Ex01.txt"); // ������ ���ٸ� ��������
			int data = 0;
			while((data = fr.read()) != -1) {
				System.out.println("read data : " + data + " ��ȯ : " + (char)data);
				//fw.write(data);
				// ����!
				// ����, ����, �� ���ڴ� write��������
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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// ���� ���! ���� ������ ������ ó�� ��������!
// ����!
// IOEx2.java�� ���۸� ���� �дµ�, ���� ������ �д´�.
// ���� : ;�� �ִ� ���常 �ֿܼ� ���(���Ϸ� ��������) 

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
			
//			// �����
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

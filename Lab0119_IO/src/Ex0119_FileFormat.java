import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex0119_FileFormat {
	public static void main(String[] args) {
		File dir = new File("C:\\Temp");
		File[] files = dir.listFiles(); // ���丮 ������ ��� ����!!!
		for(int i = 0 ; i < files.length ; i++) {
			File file = files[i];
			String name = file.getName();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mma"); // a�� ����? ���� ���� ǥ��
			String attribute = "";
			String size = "";
			//Date data = new Date(); // �ڹٿ��� Date�� ���� ������ ���̾�. Calendar�� ��ü!
			if(files[i].isDirectory()) {
				attribute = "<DIR>";
			} else {
				size = file.length() + "bytes";
				attribute = file.canRead() ? "R" : "";
				attribute += file.canWrite() ? "W" : "";
				attribute += file.canExecute() ? "E" : "";
				attribute += file.isHidden() ? "H" : "";
			}
			System.out.printf("%s %3s %10s %s \n",
					df.format(new Date(file.lastModified())),
					attribute,
					size,
					name);
			
		}
	}
}

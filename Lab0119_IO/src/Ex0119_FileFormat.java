import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex0119_FileFormat {
	public static void main(String[] args) {
		File dir = new File("C:\\Temp");
		File[] files = dir.listFiles(); // 디렉토리 파일의 모든 정보!!!
		for(int i = 0 ; i < files.length ; i++) {
			File file = files[i];
			String name = file.getName();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mma"); // a는 뭐야? 오전 오후 표기
			String attribute = "";
			String size = "";
			//Date data = new Date(); // 자바에서 Date는 이제 없어질 것이야. Calendar로 대체!
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

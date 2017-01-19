import java.io.File;

// File Class

// MS는 File과 Directory 다루는 클래스가 다르다.
// Java 진영에서는 File에 파일, 폴더 둘 다 다루게 해놓았다...

// <경로>
// - 절대 : C:~, D:~
// - 상대 : 현재 위치를 중심으로

public class Ex0119_File2 {
	 public static void main(String[] args) {
		 String path = "C:\\Temp\\aaa\\aaa.txt";
		 File f = new File(path);
		 
		 String filename = f.getName();
		 System.out.println(filename);
		 // f.delete();
		 // 파일명과 확장자 분리 가능!
		 int pos = filename.indexOf(".");
		 System.out.println(pos);
		 
		 System.out.println("전체 경로 : " + f.getPath());
		 System.out.println("절대 경로 : " + f.getAbsolutePath());
		 System.out.println("폴더니? " + f.isDirectory());
		 System.out.println("파일이니? " + f.isFile());
		 System.out.println("파일 크기? " + f.length() + " bytes");
		 System.out.println("파일 존재 여부? " + f.exists());
	 }
}

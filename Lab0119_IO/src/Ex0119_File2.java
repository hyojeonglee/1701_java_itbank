import java.io.File;

// File Class

// MS�� File�� Directory �ٷ�� Ŭ������ �ٸ���.
// Java ���������� File�� ����, ���� �� �� �ٷ�� �س��Ҵ�...

// <���>
// - ���� : C:~, D:~
// - ��� : ���� ��ġ�� �߽�����

public class Ex0119_File2 {
	 public static void main(String[] args) {
		 String path = "C:\\Temp\\aaa\\aaa.txt";
		 File f = new File(path);
		 
		 String filename = f.getName();
		 System.out.println(filename);
		 // f.delete();
		 // ���ϸ�� Ȯ���� �и� ����!
		 int pos = filename.indexOf(".");
		 System.out.println(pos);
		 
		 System.out.println("��ü ��� : " + f.getPath());
		 System.out.println("���� ��� : " + f.getAbsolutePath());
		 System.out.println("������? " + f.isDirectory());
		 System.out.println("�����̴�? " + f.isFile());
		 System.out.println("���� ũ��? " + f.length() + " bytes");
		 System.out.println("���� ���� ����? " + f.exists());
	 }
}

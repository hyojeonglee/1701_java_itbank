import java.io.File;
import java.util.ArrayList;

public class Ex0119_File_List {
	static int totalFiles = 0;
	static int totalDirs = 0;
	static int numberOfCall = 0;
	
	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("���� : java ���ϸ� [���丮 ���]");
			System.out.println("���� : java Ex0119_File_List C:\\Temp");
			System.exit(0); // ���α׷� ����
		}
		File f = new File(args[0]);
		if(!f.exists() || !f.isDirectory()) {
			System.out.println("��ȿ���� ���� ���丮");
			System.exit(0);	
		}
		// ���� ���
		printFileList(f);
		System.out.println("�� ���� �� : " + totalFiles);
		System.out.println("���丮 �� ���� : " + totalDirs);
		System.out.println("printFilsList()�� �Ҹ� Ƚ�� : " + numberOfCall);
	}
	
	static void printFileList(File dir) {
		numberOfCall++;
		System.out.println("[Full path : " + dir.getAbsolutePath() + "]");
		// ���� ���� ����
		ArrayList<Integer> subDir = new ArrayList<>();
		File[] files = null;
		int DirNum = 0;
		int fileNum = 0;
		
		if(dir.listFiles() != null) {
		files = dir.listFiles();
			for(int i = 0 ; i < files.length ; i++) {
				String fileName = files[i].getName(); // ����, ���ϸ�
				if(files[i].isDirectory()) {
					fileName = "<DIR>[" + fileName + "]";
					subDir.add(i); // ������ �� ������ ���丮�� �ε����� �־��ش�!
				}
				else { 
					fileName = fileName + " / " + files[i].length() + "Bytes";
				}
				System.out.println(" " + fileName);
			}
			DirNum = subDir.size();
			fileNum = files.length - DirNum;
		}
		
		// static ����
		totalDirs += DirNum;
		totalFiles += fileNum;
		
		System.out.println("[Current DirNum] : " + DirNum);
		System.out.println("[Current FileNum] : " + fileNum);
		System.out.println("************************************");
		
		for(int j = 0 ; j < subDir.size() ; j++) {
			int index = subDir.get(j); // ���� ����Ʈ �߿��� �Ʊ� ������ �ε����� ���丮�� ã�´�.
			printFileList(files[index]); // ��� ȣ��
		}
	}
}

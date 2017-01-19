import java.io.File;
import java.util.ArrayList;

public class Ex0119_File_List {
	static int totalFiles = 0;
	static int totalDirs = 0;
	static int numberOfCall = 0;
	
	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("사용법 : java 파일명 [디렉토리 경로]");
			System.out.println("예시 : java Ex0119_File_List C:\\Temp");
			System.exit(0); // 프로그램 종료
		}
		File f = new File(args[0]);
		if(!f.exists() || !f.isDirectory()) {
			System.out.println("유효하지 않은 디렉토리");
			System.exit(0);	
		}
		// 정보 출력
		printFileList(f);
		System.out.println("총 파일 수 : " + totalFiles);
		System.out.println("디렉토리 총 개수 : " + totalDirs);
		System.out.println("printFilsList()가 불린 횟수 : " + numberOfCall);
	}
	
	static void printFileList(File dir) {
		numberOfCall++;
		System.out.println("[Full path : " + dir.getAbsolutePath() + "]");
		// 하위 폴더 정보
		ArrayList<Integer> subDir = new ArrayList<>();
		File[] files = null;
		int DirNum = 0;
		int fileNum = 0;
		
		if(dir.listFiles() != null) {
		files = dir.listFiles();
			for(int i = 0 ; i < files.length ; i++) {
				String fileName = files[i].getName(); // 폴더, 파일명
				if(files[i].isDirectory()) {
					fileName = "<DIR>[" + fileName + "]";
					subDir.add(i); // 파일을 쭉 읽으며 디렉토리의 인덱스를 넣어준다!
				}
				else { 
					fileName = fileName + " / " + files[i].length() + "Bytes";
				}
				System.out.println(" " + fileName);
			}
			DirNum = subDir.size();
			fileNum = files.length - DirNum;
		}
		
		// static 변수
		totalDirs += DirNum;
		totalFiles += fileNum;
		
		System.out.println("[Current DirNum] : " + DirNum);
		System.out.println("[Current FileNum] : " + fileNum);
		System.out.println("************************************");
		
		for(int j = 0 ; j < subDir.size() ; j++) {
			int index = subDir.get(j); // 파일 리스트 중에서 아까 저장한 인덱스로 디렉토리를 찾는다.
			printFileList(files[index]); // 재귀 호출
		}
	}
}

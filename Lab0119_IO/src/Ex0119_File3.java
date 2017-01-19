import java.io.File;

// [run as] - run configuration - argument에 값을 넣는다.
// 이것은 cmd에서 자바 파일 실행할 때 파라미터 주는 것과 같은 것이다.
public class Ex0119_File3 {
	public static void main(String[] args) {
		
		
		if(args.length != 1) {
			System.out.println("사용법 : java 파일명 [폴더명]");
			System.exit(0);
		}
		File f = new File(args[0]); 
		if(!f.exists() || !f.isDirectory()) {
			System.out.println("유효하지 않은 디렉토리입니다.");
			System.exit(0);
		}
		
		// 유효한 폴더인 경우!
		File[] files = f.listFiles();
		for(int i = 0 ; i < files.length ; i++) {
			String name = files[i].getName(); // 폴더명일수도, 파일명일수도 있다.
			System.out.println(files[i].isDirectory() ? "<DIR> " + name : name);
		}
	}
}

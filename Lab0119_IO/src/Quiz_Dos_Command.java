import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Quiz_Dos_Command {
	public static void main(String[] args) throws Exception {
		while(true) {
			if(args.length == 0) {
				System.out.println("사용법 : java Quiz_Dos_Command cd [디렉토리명]");
				System.out.println("사용법 : java Quiz_Dos_Command rd 디렉토리명");
				System.out.println("사용법 : java Quiz_Dos_Command type 파일명");
				System.out.println("사용법 : java Quiz_Dos_Command exit");
				System.exit(0); // 프로그램 종료
			}
			if(args[0].equals("exit")) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}
			switch(args[0]) {
			case "cd" :
				if(args.length == 2)
					commandCd(args[1]);
				else
					commandCd();
				break;
			case "rd" :
				if(args.length == 1) {
					System.out.println("지울 디렉터리 명을 입력해주세요.");
					System.exit(0);
				}
				commandRd(args[1]);
				break;
			case "type" :
				if(args.length == 1) {
					System.out.println("읽을 파일 명을 입력해주세요.");
					System.exit(0);
				}
				commandType(args[1]);
				break;
			}
			System.exit(0);
		}
	}
	
	public static void commandCd() {
		System.out.println(System.getProperty("user.dir"));
	}
	
	public static void commandCd(String arg) throws Exception {
		File f = new File(arg);
		if(!f.exists() || !f.isDirectory()) {
			System.out.println("유효하지 않은 디렉토리");
			System.exit(0);	
		}
//		String str = null;
//		Process p = new ProcessBuilder("cmd", arg).start();
//		BufferedReader stdOut = new BufferedReader(new InputStreamReader(p.getInputStream()));
//		while( (str = stdOut.readLine()) != null ) {
//	        System.out.println(str);
//		}
		// cd 디렉터리 :  어떻게 구현하지?
	}
	
	public static void commandRd(String arg) {
		File f = new File(arg);
		if(!f.exists() || !f.isDirectory()) {
			System.out.println("유효하지 않은 디렉토리");
			System.exit(0);	
		}
		if(f.listFiles() != null)
			System.out.println("디렉터리 내에 파일이 있어 지울 수 없습니다.");
		f.delete();
	}
	
	@SuppressWarnings("resource")
	public static void commandType(String arg) throws Exception {
		File f = new File(arg);
		if(!f.exists() || !f.isFile()) {
			System.out.println("유효하지 않은 파일");
			System.exit(0);	
		}
		FileReader fr = null;
		BufferedReader br = null;
		String sCurrentLine;

		br = new BufferedReader(new FileReader(arg));

		for(int i = 0 ; (sCurrentLine = br.readLine()) != null ; i++) {
			System.out.println(sCurrentLine);
		}
	}
}

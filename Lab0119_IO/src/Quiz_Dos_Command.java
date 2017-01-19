import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Quiz_Dos_Command {
	public static void main(String[] args) throws Exception {
		while(true) {
			if(args.length == 0) {
				System.out.println("���� : java Quiz_Dos_Command cd [���丮��]");
				System.out.println("���� : java Quiz_Dos_Command rd ���丮��");
				System.out.println("���� : java Quiz_Dos_Command type ���ϸ�");
				System.out.println("���� : java Quiz_Dos_Command exit");
				System.exit(0); // ���α׷� ����
			}
			if(args[0].equals("exit")) {
				System.out.println("���α׷��� �����մϴ�.");
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
					System.out.println("���� ���͸� ���� �Է����ּ���.");
					System.exit(0);
				}
				commandRd(args[1]);
				break;
			case "type" :
				if(args.length == 1) {
					System.out.println("���� ���� ���� �Է����ּ���.");
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
			System.out.println("��ȿ���� ���� ���丮");
			System.exit(0);	
		}
//		String str = null;
//		Process p = new ProcessBuilder("cmd", arg).start();
//		BufferedReader stdOut = new BufferedReader(new InputStreamReader(p.getInputStream()));
//		while( (str = stdOut.readLine()) != null ) {
//	        System.out.println(str);
//		}
		// cd ���͸� :  ��� ��������?
	}
	
	public static void commandRd(String arg) {
		File f = new File(arg);
		if(!f.exists() || !f.isDirectory()) {
			System.out.println("��ȿ���� ���� ���丮");
			System.exit(0);	
		}
		if(f.listFiles() != null)
			System.out.println("���͸� ���� ������ �־� ���� �� �����ϴ�.");
		f.delete();
	}
	
	@SuppressWarnings("resource")
	public static void commandType(String arg) throws Exception {
		File f = new File(arg);
		if(!f.exists() || !f.isFile()) {
			System.out.println("��ȿ���� ���� ����");
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

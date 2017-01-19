import java.io.File;

// [run as] - run configuration - argument�� ���� �ִ´�.
// �̰��� cmd���� �ڹ� ���� ������ �� �Ķ���� �ִ� �Ͱ� ���� ���̴�.
public class Ex0119_File3 {
	public static void main(String[] args) {
		
		
		if(args.length != 1) {
			System.out.println("���� : java ���ϸ� [������]");
			System.exit(0);
		}
		File f = new File(args[0]); 
		if(!f.exists() || !f.isDirectory()) {
			System.out.println("��ȿ���� ���� ���丮�Դϴ�.");
			System.exit(0);
		}
		
		// ��ȿ�� ������ ���!
		File[] files = f.listFiles();
		for(int i = 0 ; i < files.length ; i++) {
			String name = files[i].getName(); // �������ϼ���, ���ϸ��ϼ��� �ִ�.
			System.out.println(files[i].isDirectory() ? "<DIR> " + name : name);
		}
	}
}

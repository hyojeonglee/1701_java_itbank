// install ���α׷� (CD)
// ��ġ ���� > �ӽ� ������ ���� > ��ġ > �Ϸ� > �ӽ����� ����
// ���� ��ġ�ϴٰ� ���� �߻��ϸ� �ӽ� ������ �����ִ� ���·� ���α׷� Die
// Q. ���� �߻��ص� �ӽ������� ����� ������? A. finally ��� ���


public class Ex0117_Exception2 {
	static void startInstall() {
		System.out.println("install");
	}
	static void copyFiles() {
		System.out.println("copyFiles");
	}
	static void deleteFiles() {
		System.out.println("deleteFiles");
	}
	public static void main(String[] args) {
		try {
			startInstall();
			copyFiles();
			throw new Exception("���� ����"); // ������ ���� �߻���Ŵ!
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			deleteFiles();
		}
	}
}

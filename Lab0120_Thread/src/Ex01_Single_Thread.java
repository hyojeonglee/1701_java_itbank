

// single process + single thread
// JVM > stack �޸� �ϳ��� ���!

public class Ex01_Single_Thread {
	public static void main(String[] args) {
		System.out.println("Main thread ����");
		worker();
		worker2();
		System.out.println("Main thread ����");
	}
	
	static void worker() {
		System.out.println("1��");
	}
	
	static void worker2() {
		System.out.println("2��");
	}
}

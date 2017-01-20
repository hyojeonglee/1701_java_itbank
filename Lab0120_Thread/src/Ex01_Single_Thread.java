

// single process + single thread
// JVM > stack 메모리 하나만 사용!

public class Ex01_Single_Thread {
	public static void main(String[] args) {
		System.out.println("Main thread 시작");
		worker();
		worker2();
		System.out.println("Main thread 종료");
	}
	
	static void worker() {
		System.out.println("1번");
	}
	
	static void worker2() {
		System.out.println("2번");
	}
}

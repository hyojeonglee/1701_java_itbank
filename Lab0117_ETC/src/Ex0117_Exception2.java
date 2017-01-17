// install 프로그램 (CD)
// 설치 시작 > 임시 폴더에 복사 > 설치 > 완료 > 임시폴더 삭제
// 만약 설치하다가 예외 발생하면 임시 폴더가 남아있는 상태로 프로그램 Die
// Q. 예외 발생해도 임시폴더를 지우고 싶으면? A. finally 블록 사용


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
			throw new Exception("복사 오류"); // 강제로 예외 발생시킴!
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			deleteFiles();
		}
	}
}

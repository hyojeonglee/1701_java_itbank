// <에러 vs 예외>
// 1. 에러 : 네트워크 장애, 메모리, 하드웨어
// 2. 예외 : 개발자가 처리 가능한 것들! 코드 개발 시 예측 가능한 문제(실행 시)
// 예외처리는 에러를 해결하는것이 아니고, 프로그램이 강제로 죽는것만 막는것!
// 문제를 해결하는 코드는 아님

public class Ex0117_Exception {
	public static void main(String[] args) {
		int num = 100;
		int result = 0;
		int[] array = new int[3];
		// 원리 : 예외발생하면 예외 객체가 만들어짐
		// 여기서는 ArithmeticException 객체가 만들어져 catch에서 받게 됨.
		try {
			for(int i = 0 ; i < 10 ; i++) {
				result = num / (int) (Math.random()*10);
				System.out.println(result);
				array[i] = i;
			}
		} catch (ArithmeticException e) { // specific한 예외를 먼저 써주어야함!
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("예외발생해도 그냥 실행하는 블록, 위에서 return해도 실행해준다.");
		}
		System.out.println("Main end");
		// catch 블록이 예외를 처리해주고, 메인함수 마지막까지 실행해준다.(강제종료 막음)
	}
}

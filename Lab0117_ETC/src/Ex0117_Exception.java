// <���� vs ����>
// 1. ���� : ��Ʈ��ũ ���, �޸�, �ϵ����
// 2. ���� : �����ڰ� ó�� ������ �͵�! �ڵ� ���� �� ���� ������ ����(���� ��)
// ����ó���� ������ �ذ��ϴ°��� �ƴϰ�, ���α׷��� ������ �״°͸� ���°�!
// ������ �ذ��ϴ� �ڵ�� �ƴ�

public class Ex0117_Exception {
	public static void main(String[] args) {
		int num = 100;
		int result = 0;
		int[] array = new int[3];
		// ���� : ���ܹ߻��ϸ� ���� ��ü�� �������
		// ���⼭�� ArithmeticException ��ü�� ������� catch���� �ް� ��.
		try {
			for(int i = 0 ; i < 10 ; i++) {
				result = num / (int) (Math.random()*10);
				System.out.println(result);
				array[i] = i;
			}
		} catch (ArithmeticException e) { // specific�� ���ܸ� ���� ���־����!
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("���ܹ߻��ص� �׳� �����ϴ� ���, ������ return�ص� �������ش�.");
		}
		System.out.println("Main end");
		// catch ����� ���ܸ� ó�����ְ�, �����Լ� ���������� �������ش�.(�������� ����)
	}
}

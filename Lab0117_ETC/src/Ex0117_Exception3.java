// <�޼ҵ� ���� ������>
class Test {
	void call() throws Exception, ArithmeticException, IndexOutOfBoundsException {
		// ���� ������ ���� �� �𸣰ڴ� ���
		System.out.println("Call �Լ� start");
		int i = 1 / 0;
		System.out.println("Call �Լ� End");
	}
}

public class Ex0117_Exception3 {
	public static void main(String[] args) {
		Test t = new Test();
		// t.call(); ������ �׾����鼭 ����ó���� �϶�� �Ѵ�.
		try {
			t.call();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

class StaticM {
	int iv;
	static int cv;
	
	void m() {
		cv = 1000; // �Ϲ� �Լ����� static �ڿ� ���� ����
	}
	
	static void sm() { // �������� ó���ϸ� ���� ����~
		// iv = 100; static �Լ����� �Ϲ� �ڿ� ���� �Ұ�
	}
}

//Q. static �Լ��� �ǵ�? ��ü �������� �ʾƵ� ����� �� �ִ�. ���� ����ϴ� �ڿ��� ���!
public class Ex0113_Static_Method {
	public void callMethod() {
		
	}
	
	public static void callSMethod() {
		
	}
	
	public static void main(String[] args) {
		int c = StaticM.cv;
		StaticM.sm();
		
		// case 1. not static
		Ex0113_Static_Method s = new Ex0113_Static_Method();
		s.callMethod();
		
		// case 2. static
		Ex0113_Static_Method.callSMethod();
	}
}
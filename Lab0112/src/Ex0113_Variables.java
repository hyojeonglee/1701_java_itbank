import kr.or.bank.Car;

public class Ex0113_Variables {
	public static void main(String [] args) {
		String str = "ȫ�浿";
		// ������ Ŭ�����̴�! ��� �ÿ��� �Ϲ� Ÿ��ó�� ����ϰ� heap ������ ����!
		// cf. static => stack ������ ����!
		String s  = "A"; // str -->A
		s += "B"; // str-->AB(���ο� �޸� �����ϰ� �� �� ����Ŵ)
		s += "C"; // str-->ABC ���� ���ڿ� �����ϴ� ���� String ���� �޸� ���� ����ŭ ����ϱ� ������ ���� ��������. �̷��� string builder ���
		s = "A"; // ���ο� �޸� ������ �ƴ�, ���� �ִ� �޸� A�ٽ� ����Ŵ   
		System.out.println(s);
	      
		char c = '��';

		
		System.out.println("ȫ\"��\"��"); // ��ȣ ����� ���� \ ���!
		System.out.println("100" + 100); // 100100
		System.out.println(100 + "100");
		System.out.println(100 + 100 + "100");
		System.out.println(100 + "100" + 100);
		
		Car c1 = new Car(); // Ŭ������ Ÿ���̴�! (�޸𸮿� �ø����� new ������ ���)
		System.out.println(c1.hashCode());
		Car c2 = new Car();
		System.out.println(c1.hashCode());
		System.out.println(c1.equals(c2)); // instanceOf()�� �� ���!
	}
}
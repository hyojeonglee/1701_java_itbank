import java.util.Vector;

public class Ex0117_Vector {
	public static void main(String[] args) {
		Vector v = new Vector();
		v.add("abc");
		v.add(100);
		v.add('a');
		System.out.println(v.toString());
		for(int i = 0 ; i < v.size() ; i++)
			System.out.println(v.get(i));
		for(Object ob : v)
			System.out.println(ob);
		// ���Ͱ��� object ������ �ذ��ϱ����� (���� �ʹ�����)
		// Generic ����! ��ü ���鶧 Ÿ���� �����ϴ� ��
		Vector<String> v2 = new Vector<>();
		// Object[] data > String[] data
		System.out.println("before " + v2.capacity());
		v2.add("AAA");
		v2.add("AAA");
		v2.add("AAA");
		v2.add("AAA");
		v2.add("AAA");
		v2.add("AAA");
		v2.add("AAA");
		v2.add("AAA");
		v2.add("AAA");
		v2.add("AAA");
		v2.add("AAA");
		// �̷��� ������ 11�� �߰��ϸ�! 1������ �뷮�� 10����, �� �� �ø��� 2�ε� 10*2���ִϱ� 20(����Ʈ ��Ģ!)
		for(String str : v2)
			System.out.println(str);
		System.out.println(v2.toString());
		System.out.println(v2.size());
		System.out.println("after " + v2.capacity()); // �뷮 �� �ְ� �����ߴµ� ����Ʈ�� 10�� ������.
	}
}

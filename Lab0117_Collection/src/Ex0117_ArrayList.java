import java.util.ArrayList;
import java.util.List;

public class Ex0117_ArrayList {

	public static void main(String[] args) {
		ArrayList arraylist = new ArrayList();
		arraylist.add(1);
		arraylist.add(2);
		arraylist.add(3);
		
		System.out.println(arraylist.size()); // capacity�� �����ȵ�
		System.out.println(arraylist.get(0));
		System.out.println(arraylist.toString());
		System.out.println(arraylist.isEmpty());
		
		int index = 0;
		arraylist.remove(index); // �ڿ��ִ� 2, 3�� ������ �������.
		System.out.println(arraylist.toString());
		// arraylist.remove(3); // index out of bounds
		// Q. ��ü 3�� ��������ߴµ� �ε��� 3���� �����ع��� > ��¿�� ����...
		
		ArrayList list = new ArrayList();
		list.add("��");
		list.add("��");
		list.add("��");
		list.add("��");
		
		// Q. �� �� '��'�� ������� �ϸ� ù��° ���� �����.
		list.remove("��");
		System.out.println(list.toString());
		
		// ***�������̽��� ��ü�� �޴� ������ ������
		List list2 = new ArrayList(); // �������̽��� ����� ���ٹ�
		
		// �Լ�
		// public void run(List list) {} (����^^ - ��������)
		// public void run(ArrayList list) {} (�� ����Ф�)
	}

}

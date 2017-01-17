import java.util.ArrayList;

import kr.or.bank.Emp;

public class Ex0117_ArrayList_Object {
	public static void main(String[] args) {
		// Emp ��ü
		Emp emp1 = new Emp(1000, "��ȿ��", "������");
		System.out.println(emp1.toString());
		
		// Emp ��ü �迭
		Emp[] eArray = {new Emp(2000, "��ȿ��", "������"), 
						new Emp(3000, "�̹̿�", "����")};
		for(Emp emp : eArray)
			System.out.println(emp.toString());
		
		// Emp �÷��� (�����)
		ArrayList list = new ArrayList();
		list.add(new Emp(100, "������", "�л�"));
		list.add(new Emp(1700, "������", "����"));
		list.add(new Emp(1500, "������", "����"));
		// �׳� for
		for(int i = 0 ; i < list.size() ; i++)
			System.out.println(((Emp)list.get(i)).getName()); // �̳� ��������~
		// ���� for
		for(Object obj : list) {
			Emp emp = (Emp) obj;
			System.out.println(emp.getEmpNo() + emp.getName() + emp.getJob());
		}
		// �� �� �ڵ�� �߸��� ��!
		
		// *** Emp �÷��� with ���ʸ� (���ϴ�!)
		ArrayList<Emp> empList = new ArrayList<>();
		empList.add(new Emp(3000, "�̼���", "����"));
		empList.add(new Emp(2000, "�̼���", "����"));
		empList.add(new Emp(1000, "�̼���", "����"));
		
		for(Emp emp : empList)
			System.out.println(emp.toString());
	}
}

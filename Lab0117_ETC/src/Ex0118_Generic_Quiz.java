import java.util.ArrayList;
import java.util.Iterator;

import kr.or.bank.CopyEmp;
import kr.or.bank.Emp;

public class Ex0118_Generic_Quiz {
	public static void main(String[] args) {
		// 1. Emp Ŭ������ ����ؼ� ��� 3�� �����
		// 2. ����� ����(���, �̸�, ����)�� ������ for�� ���!
		// 3. �Ϲ� for������ ����ϱ�
		// 4. CopyEmp Ŭ���� ���� job ��� sal�� �ٲ۴�.
		//		- ������ �ִ� ��� 100, "��", 1000 / 200, "��", 2000 / 300, "��", 3000
		// 4-1. 200�� ����� �޿��� 5000���� �λ��ؼ� ����ϱ�!
		// 4-2. 300�� ����� �̸��� "ȫ"�̶�� �����ؼ� ����ϱ�!
		// 4-3. ��������� iterator�� ����ؼ� ����϶�.
		
		ArrayList<Emp> empList = new ArrayList<>();
		empList.add(new Emp(100, "ȿ��", "SI"));
		empList.add(new Emp(101, "����", "EDU"));
		empList.add(new Emp(102, "�ƿ�", "SM"));
		
		for(Emp e : empList) {
			System.out.println(e.toString());
		}
		
		for(int i = 0 ; i < empList.size() ; i++)
			System.out.println(empList.get(i).toString());
		
		System.out.println("-----------4�� ����-----------");
		
		ArrayList<CopyEmp> cempList = new ArrayList<>();
		cempList.add(new CopyEmp(100, "��", 1000));
		cempList.add(new CopyEmp(200, "��", 2000));
		cempList.add(new CopyEmp(300, "��", 3000));
		
		// ��
		for(CopyEmp e : cempList) {
			if(e.getEmpNo() == 200) {
				e.setSal(5000);
				System.out.println("�����λ� " + e.toString());
			}
			if(e.getName().equals("��")) {
				e.setName("ȫ");
				System.out.println("�̸����� " + e.toString());
			}
		}
		
		// Iterator, ListIterator > ArrayList�� iterator�� �����ϰ� �ִ�~
		// iterator interface > Collection interface > ArrayList class�� ����!
		
		Iterator<CopyEmp> i = cempList.iterator(); // �굵 ���ʸ� ������~
		while(i.hasNext()) {
			// ���� ���� ���� : hasNext�� ���� ĭ���� �̵��ϸ鼭 ������ true ����!
			// ArrayList ���� �����Ǿ��ִ�.
			System.out.println(i.next());
		}
	}
}

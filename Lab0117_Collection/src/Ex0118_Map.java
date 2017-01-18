import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Map �������̽� �����ϴ� Ŭ����
// Map(Ű, ��) �ֹ迭
// ������ȣ (02 > ����, 031 > ��⵵)

// Ŭ���� HashTable�� ������!(��� ����ȭ ����)
// HashMap�� �Ź���!(����ȭ���� ����!)

// ���������� Generic ����!

// Map�� ������ ����ϴ� �� : ��ü�� ��Ƴ��� > ���� Ex0118_Map_apply
public class Ex0118_Map {
	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("Tiger", "1004");
		map.put("scott", "1004");
		
		// <Map�� �Լ��� �˾ƺ���>
		System.out.println("---2 key�� value �˱�");
		System.out.println(map.containsKey("tiger")); // ��ҹ��� ������ �ұ�?
		// ����� false ��ҹ��� �����Ѵ�!
		System.out.println(map.containsKey("Tiger"));
		
		System.out.println("---2 value�� key �˱�");
		System.out.println(map.containsValue("1004"));
		// value �ϳ��� ������ true
		
		System.out.println("---3 get");
		System.out.println(map.get("Tiger"));
		System.out.println(map.get("aaa"));
		// ã�� ��� ������ null ����
		
		System.out.println("---4 put");
		map.put("Tiger", 1007);
		System.out.println(map.containsKey("Tiger"));
		System.out.println(map.get("Tiger")); // 1007�� ���´�.
		// key�� ���� ���� put�ϸ� value�� overwrite�Ѵ�.
		
		System.out.println("---5 remove");
		System.out.println(map.remove("Tiger"));
		// ���� ��, ���� ���� value���̴�! ������� value�� �� �� �ֳ�
		
		map.put("Tiger", 1008);
		
		System.out.println("---6 keySet()");
		// key�鸸 �̾Ƽ� ����(Set)�� ����� �� �ּҸ� �����Ѵ�.
		Set keyset = map.keySet(); // �̶� ����Ÿ���� interface Set�̴�. ��?
		Iterator it = keyset.iterator();
		while(it.hasNext())
			System.out.println(it.next());
		
		System.out.println("---7 values()");
		Collection cList = map.values(); // ����Ÿ���� �÷���
		// List cList2 = (List) map.values(); // ����? ������� ã�ƺ��Ŵ�.
		System.out.println(cList.toString());
		
		// ���߿�
		System.out.println("---8 entrySet()");
		Set set = map.entrySet(); // ("A", 1004)�� A=1004 ���·�!
		Iterator i = set.iterator();
		while(i.hasNext())
			System.out.println(i.next());
	}
}

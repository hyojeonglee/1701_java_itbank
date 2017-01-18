import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

// ctrl + shift + o

// HashSet
// ������ ���� �ߺ��� ������� �ʴ´�.

public class Ex0118_HashSet {
	public static void main(String[] args) {
		// HashSet (�ߺ����� + �������� ����)
		HashSet hs = new HashSet();
		Set h = new HashSet();
		HashSet<String> hs2 = new HashSet<>();
		
		hs2.add("B");
		hs2.add("F");
		hs2.add("K");
		hs2.add("B");
		System.out.println(hs2.toString());
		// �ߺ����� �ִ´ٰ� �ؼ� ������ ���� �ʴ´�! > �ζ� �������� ���ϰڴ�!
		
		// TreeSet (�ߺ����� + ���������� "����" ����� �ִ�!)
		// - ����Ʈ������ ���İ� �˻��� �������Ѵ�.
		// - ���� ���� �����͸� �����ؾ��ϴ� �˻������ ȿ�������� ���� �� �ִ�.
		Set<String> h3 = new TreeSet<>();
		h3.add("B");
		h3.add("F");
		h3.add("A");
		h3.add("K");
		h3.add("C");
		System.out.println(h3.toString()); // ������~~~
		
		// ����. TreeSet �Ἥ �ζǸ� ������~
		// 1 ���� 45���� 6�� ����
		Set<Integer> lotto = new TreeSet<>();
		while(lotto.size() != 6) {
			Random r = new Random();
			lotto.add(r.nextInt(45) + 1);
		}
		// ����� �ڵ�
//		for(int i = 0 ; lotto.size() < 6 ; i++) {
//			int num = (int)(Math.random()*45) + 1;
//			lotto.add(num);
//		}
		System.out.println(lotto.toString());
	}
}

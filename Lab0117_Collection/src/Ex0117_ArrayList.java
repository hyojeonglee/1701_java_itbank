import java.util.ArrayList;
import java.util.List;

public class Ex0117_ArrayList {

	public static void main(String[] args) {
		ArrayList arraylist = new ArrayList();
		arraylist.add(1);
		arraylist.add(2);
		arraylist.add(3);
		
		System.out.println(arraylist.size()); // capacity는 공개안됨
		System.out.println(arraylist.get(0));
		System.out.println(arraylist.toString());
		System.out.println(arraylist.isEmpty());
		
		int index = 0;
		arraylist.remove(index); // 뒤에있던 2, 3이 앞으로 당겨진다.
		System.out.println(arraylist.toString());
		// arraylist.remove(3); // index out of bounds
		// Q. 객체 3을 지우려고했는데 인덱스 3으로 생각해버림 > 어쩔수 없다...
		
		ArrayList list = new ArrayList();
		list.add("가");
		list.add("나");
		list.add("다");
		list.add("가");
		
		// Q. 이 때 '가'를 지우려고 하면 첫번째 것을 지운다.
		list.remove("가");
		System.out.println(list.toString());
		
		// ***인터페이스를 객체로 받는 습관을 들이자
		List list2 = new ArrayList(); // 인터페이스의 명시적 접근법
		
		// 함수
		// public void run(List list) {} (권장^^ - 간접접근)
		// public void run(ArrayList list) {} (안 권장ㅠㅠ)
	}

}

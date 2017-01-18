import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

// ctrl + shift + o

// HashSet
// 순서가 없고 중복을 허락하지 않는다.

public class Ex0118_HashSet {
	public static void main(String[] args) {
		// HashSet (중복제거 + 정렬하지 않음)
		HashSet hs = new HashSet();
		Set h = new HashSet();
		HashSet<String> hs2 = new HashSet<>();
		
		hs2.add("B");
		hs2.add("F");
		hs2.add("K");
		hs2.add("B");
		System.out.println(hs2.toString());
		// 중복값을 넣는다고 해서 에러가 나진 않는다! > 로또 예제에서 편하겠당!
		
		// TreeSet (중복제거 + 내부적으로 "정렬" 기능이 있다!)
		// - 이진트리에서 정렬과 검색을 가능케한다.
		// - 많은 양의 데이터를 저장해야하는 검색기능을 효율적으로 해줄 수 있다.
		Set<String> h3 = new TreeSet<>();
		h3.add("B");
		h3.add("F");
		h3.add("A");
		h3.add("K");
		h3.add("C");
		System.out.println(h3.toString()); // 오오오~~~
		
		// 문제. TreeSet 써서 로또를 만들어라~
		// 1 부터 45까지 6개 숫자
		Set<Integer> lotto = new TreeSet<>();
		while(lotto.size() != 6) {
			Random r = new Random();
			lotto.add(r.nextInt(45) + 1);
		}
		// 강사님 코드
//		for(int i = 0 ; lotto.size() < 6 ; i++) {
//			int num = (int)(Math.random()*45) + 1;
//			lotto.add(num);
//		}
		System.out.println(lotto.toString());
	}
}

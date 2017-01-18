import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Map 인터페이스 구현하는 클래스
// Map(키, 값) 쌍배열
// 지역번호 (02 > 서울, 031 > 경기도)

// 클래스 HashTable이 구버전!(얘는 동기화 보장)
// HashMap이 신버전!(동기화보장 안함!)

// 마찬가지로 Generic 지원!

// Map을 실제로 사용하는 곳 : 객체를 담아놓기 > 예제 Ex0118_Map_apply
public class Ex0118_Map {
	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("Tiger", "1004");
		map.put("scott", "1004");
		
		// <Map의 함수를 알아보자>
		System.out.println("---2 key로 value 알기");
		System.out.println(map.containsKey("tiger")); // 대소문자 구분을 할까?
		// 결과는 false 대소문자 구별한다!
		System.out.println(map.containsKey("Tiger"));
		
		System.out.println("---2 value로 key 알기");
		System.out.println(map.containsValue("1004"));
		// value 하나라도 있으면 true
		
		System.out.println("---3 get");
		System.out.println(map.get("Tiger"));
		System.out.println(map.get("aaa"));
		// 찾는 대상 없으면 null 리턴
		
		System.out.println("---4 put");
		map.put("Tiger", 1007);
		System.out.println(map.containsKey("Tiger"));
		System.out.println(map.get("Tiger")); // 1007이 나온다.
		// key가 같은 것을 put하면 value를 overwrite한다.
		
		System.out.println("---5 remove");
		System.out.println(map.remove("Tiger"));
		// 지울 때, 리턴 값은 value값이다! 지운것의 value를 알 수 있넹
		
		map.put("Tiger", 1008);
		
		System.out.println("---6 keySet()");
		// key들만 뽑아서 집합(Set)을 만들어 그 주소를 리턴한다.
		Set keyset = map.keySet(); // 이때 리턴타입이 interface Set이다. 왜?
		Iterator it = keyset.iterator();
		while(it.hasNext())
			System.out.println(it.next());
		
		System.out.println("---7 values()");
		Collection cList = map.values(); // 리턴타입이 컬렉션
		// List cList2 = (List) map.values(); // 가능? 강사님이 찾아보신다.
		System.out.println(cList.toString());
		
		// ★중요
		System.out.println("---8 entrySet()");
		Set set = map.entrySet(); // ("A", 1004)를 A=1004 형태로!
		Iterator i = set.iterator();
		while(i.hasNext())
			System.out.println(i.next());
	}
}

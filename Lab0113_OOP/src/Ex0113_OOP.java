import kr.or.bank.Card;

// 객체 지향 언어
// 1. Method Overloading : 하나의 이름으로 여러가지 기능! 파라미터 갯수와 타입(순서) 바꾼다! (인터페이스)
// 이때 리턴타입은 상관 없다.
// Q. 개발자 입장에서 오버로딩(중복정의)를 왜 쓸까? 성능과는 상관이 없다. 편하게 쓰려고!

class OverTest {
	int add(int i) { 
		return i + 100;
	}
	
	int add(int i, int j) { // 인정
		return i + j;
	}
	
	String add(String s) { // 인정
		return s;
	}
	
	String add(String s, int i) { // 인정
		return s+i;
	}
	
	String add(int i, String s) { // 인정
		return s+i;
	}
	
	int[] add(int[] param) {
		int[] target = new int[param.length];
		for(int i = 0 ; i < param.length ; i++)
			target[i] = param[i] + 1;
		return target;
	}
	// 이 함수가 끝나면 target이라는 로컬 변수는 사라지지만 배열 자체가 사라지진않는다.(heap 메모리에 올라가 있으므로!)
	// heap 메모리는 내가 건드리는 게 아니고, 참조하지 않으면 가비지 컬렉터가 알아서 치워준다.
	
	Card add(Card c) {
		return c;
	}
	
	int[] add(int[] so, int[] so2) {
		int n = (so.length >= so2.length)? so2.length : so.length;
		int[] result = new int[n];
		for(int i = 0 ; i < n ; i++)
			result[i] = so[i] + so2[i];
		return result;
	}
}

public class Ex0113_OOP {
	public static void main(String[] args) {
		OverTest ot = new OverTest();
		Card c = new Card();
		Card c2 = ot.add(c);
		// Q. 이 때 c와 c2의 주소는 같다.
		c.equals(c2); // True
		
		// cf. c2.toString() 안 해도 c2만 써도 자동으로 해준다.
		
		Card c3 = ot.add(new Card()); // 이건 될까?
		System.out.println(c3); // 되네
		
		int[] numbers = new int[10];
		for(int i = 0 ; i < numbers.length ; i++) {
			numbers[i] = i;
			System.out.print(numbers[i]);
		}
		System.out.println("");
		numbers = ot.add(numbers);
		for(int i = 0 ; i < numbers.length ; i++)
			System.out.print(numbers[i]);
		// 개선된 for문! 객체나 배열 다룰 때는 이것 쓴다!!! 내부적으로는 while
		for(int i : numbers)
			System.out.print(i);
		System.out.println("");
		
		int[] b = {1, 2, 3, 4, 5};
		int[] b2 = {1, 2, 3, 4, 5, 6, 7};
		b2 = ot.add(b, b2);
		for(int i : b2) 
			System.out.print(i);
	}
}

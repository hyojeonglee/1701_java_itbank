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
		// 위와같은 object 문제를 해결하기위해 (낭비 너무많음)
		// Generic 등장! 객체 만들때 타입을 강제하는 것
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
		// 이렇게 열심히 11개 추가하면! 1개에서 용량이 10개고, 한 개 늘리면 2인데 10*2해주니까 20(디폴트 규칙!)
		for(String str : v2)
			System.out.println(str);
		System.out.println(v2.toString());
		System.out.println(v2.size());
		System.out.println("after " + v2.capacity()); // 용량 안 주고 생성했는데 디폴트로 10을 가진다.
	}
}

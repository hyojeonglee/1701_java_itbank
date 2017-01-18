import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// <Map 활용하기>
// - HashMap<String, Object> ... Generic
// - 학생들 성적관리
// - 아이디 : 성적 (학생 객체)

// - 실제로 사용되는 분야 : 서버 소켓 통신 (채팅)
// - java로 db안쓰고 만들 수 있는 것은 채팅! (채팅방, 귓속말, 파일업로드 등등...)

class Student {
	int kor;
	int eng;
	String name;
	
	public Student(int kor, int eng, String name) {
		this.kor = kor;
		this.eng = eng;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [kor=" + kor + ", eng=" + eng + ", name=" + name + "]";
	}
}
// sysout > Ctrl + Space = System.out.println
public class Ex0118_Map2_Hard {
	public static void main(String[] args) {
		HashMap<String, Student> students = new HashMap<>();
		students.put("hyon224", new Student(100, 90, "이효정"));
		students.put("nuri0416", new Student(100, 100, "방누리"));
		
		Set set = students.entrySet(); // 뭐가 나올까...?
		Iterator it = set.iterator();
		while(it.hasNext())
			System.out.println(it.next()); // 아이디랑 학생객체 주소값을 쌍으로 만든다.
		
		Student st = students.get("hyon224");
		System.out.println(st.name + "/" + st.eng + "/" + st.kor);
		// 얘를 좀 더 편하게 뽑는 방법! ★★★
		for(Map.Entry m : students.entrySet()) { // Map.Entry 타입으로 받으면
			// key와 value 분리 가능!
			System.out.println(m.getKey() + " / " + ((Student)m.getValue()).toString());
		}
	}
}

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// <Map Ȱ���ϱ�>
// - HashMap<String, Object> ... Generic
// - �л��� ��������
// - ���̵� : ���� (�л� ��ü)

// - ������ ���Ǵ� �о� : ���� ���� ��� (ä��)
// - java�� db�Ⱦ��� ���� �� �ִ� ���� ä��! (ä�ù�, �ӼӸ�, ���Ͼ��ε� ���...)

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
		students.put("hyon224", new Student(100, 90, "��ȿ��"));
		students.put("nuri0416", new Student(100, 100, "�洩��"));
		
		Set set = students.entrySet(); // ���� ���ñ�...?
		Iterator it = set.iterator();
		while(it.hasNext())
			System.out.println(it.next()); // ���̵�� �л���ü �ּҰ��� ������ �����.
		
		Student st = students.get("hyon224");
		System.out.println(st.name + "/" + st.eng + "/" + st.kor);
		// �긦 �� �� ���ϰ� �̴� ���! �ڡڡ�
		for(Map.Entry m : students.entrySet()) { // Map.Entry Ÿ������ ������
			// key�� value �и� ����!
			System.out.println(m.getKey() + " / " + ((Student)m.getValue()).toString());
		}
	}
}

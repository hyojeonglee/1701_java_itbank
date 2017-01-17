import java.util.ArrayList;

import kr.or.bank.Emp;

public class Ex0117_ArrayList_Object {
	public static void main(String[] args) {
		// Emp 객체
		Emp emp1 = new Emp(1000, "이효정", "개발자");
		System.out.println(emp1.toString());
		
		// Emp 객체 배열
		Emp[] eArray = {new Emp(2000, "이효원", "선생님"), 
						new Emp(3000, "이미영", "무직")};
		for(Emp emp : eArray)
			System.out.println(emp.toString());
		
		// Emp 컬렉션 (힘들어)
		ArrayList list = new ArrayList();
		list.add(new Emp(100, "이정훈", "학생"));
		list.add(new Emp(1700, "이종석", "영업"));
		list.add(new Emp(1500, "이정훈", "무직"));
		// 그냥 for
		for(int i = 0 ; i < list.size() ; i++)
			System.out.println(((Emp)list.get(i)).getName()); // 겁나 귀찮구나~
		// 개선 for
		for(Object obj : list) {
			Emp emp = (Emp) obj;
			System.out.println(emp.getEmpNo() + emp.getName() + emp.getJob());
		}
		// 위 두 코드는 잘못된 것!
		
		// *** Emp 컬렉션 with 제너릭 (편하다!)
		ArrayList<Emp> empList = new ArrayList<>();
		empList.add(new Emp(3000, "이수연", "강사"));
		empList.add(new Emp(2000, "이수연", "강사"));
		empList.add(new Emp(1000, "이수연", "강사"));
		
		for(Emp emp : empList)
			System.out.println(emp.toString());
	}
}

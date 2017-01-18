import java.util.ArrayList;
import java.util.Iterator;

import kr.or.bank.CopyEmp;
import kr.or.bank.Emp;

public class Ex0118_Generic_Quiz {
	public static void main(String[] args) {
		// 1. Emp 클래스를 사용해서 사원 3명 만들기
		// 2. 사원의 정보(사번, 이름, 직종)를 개선된 for로 출력!
		// 3. 일반 for문으로 출력하기
		// 4. CopyEmp 클래스 만들어서 job 대신 sal로 바꾼다.
		//		- 데이터 넣는 방법 100, "김", 1000 / 200, "박", 2000 / 300, "이", 3000
		// 4-1. 200번 사원의 급여를 5000으로 인상해서 출력하기!
		// 4-2. 300번 사원의 이름을 "홍"이라고 수정해서 출력하기!
		// 4-3. 사원정보를 iterator를 사용해서 출력하라.
		
		ArrayList<Emp> empList = new ArrayList<>();
		empList.add(new Emp(100, "효정", "SI"));
		empList.add(new Emp(101, "누리", "EDU"));
		empList.add(new Emp(102, "아영", "SM"));
		
		for(Emp e : empList) {
			System.out.println(e.toString());
		}
		
		for(int i = 0 ; i < empList.size() ; i++)
			System.out.println(empList.get(i).toString());
		
		System.out.println("-----------4번 문제-----------");
		
		ArrayList<CopyEmp> cempList = new ArrayList<>();
		cempList.add(new CopyEmp(100, "김", 1000));
		cempList.add(new CopyEmp(200, "박", 2000));
		cempList.add(new CopyEmp(300, "이", 3000));
		
		// 답
		for(CopyEmp e : cempList) {
			if(e.getEmpNo() == 200) {
				e.setSal(5000);
				System.out.println("연봉인상 " + e.toString());
			}
			if(e.getName().equals("이")) {
				e.setName("홍");
				System.out.println("이름변경 " + e.toString());
			}
		}
		
		// Iterator, ListIterator > ArrayList가 iterator를 구현하고 있다~
		// iterator interface > Collection interface > ArrayList class가 구현!
		
		Iterator<CopyEmp> i = cempList.iterator(); // 얘도 제너릭 해주자~
		while(i.hasNext()) {
			// 내부 실행 과정 : hasNext가 다음 칸으로 이동하면서 있으면 true 리턴!
			// ArrayList 내에 구현되어있다.
			System.out.println(i.next());
		}
	}
}

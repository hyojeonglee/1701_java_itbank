import java.util.ArrayList;
import java.util.List;

// <인터페이스>
// 동적배열<Collection>을 제대로 쓸 수 있다.
// Java API > Collection
// - 정의 : 약속, 표준, 규칙, 규약 만드는 행위!
// - ISO 문서 표준
// - 소프트웨어 개발 단계 최상 단위라 어렵다.

// - '약속'이기 때문에 구현하지는 않는다.
// - 그렇기 때문에 설명(Description)이 중요하다.
// - ex)
//		up() 엘리베이터 위로, down() 아래로
//		이 때, 표준을 따르지 않은 회사는 도태될 수 밖에 없다.

// - 결론 : 표준화된 공통 설계가 가능하다.
// - 구현이 없어서 직접 사용은 할 수 없다.
// - 인터페이스는 다른 클래스가 구현해서 사용할 수 있다.

// *정리하면
// 1. 스스로 객체 생성 불가 (100% 미완성 코드)
// 2. 구현을 통해서만 사용 가능
// 3. 인터페이스가 가지는 추상자원 강제적 구현을 하도록 한다.
// 4. 다중 상속 가능!!! (여러 개의 인터페이스 사용 가능)
// 5. 그렇기 때문에 작은 단위로 설계하는 것이 바람직

// cf. 추상클래스와 비교
//		- 공통점 : 스스로 객체 생성 불가
//		- 차이점 : 인터페이스는 100% 미완성이지만, 추상클래스는 완성코드도 가질 수 있다.

interface IA { // MS가 좋아하는 스타일 vs Java는 앞에 I 쓰고 ~able로 끝난다.
	public static final int AGE = 100; // 인터페이스 내부에는 상수를 쓸 수 있다.
	public abstract String Print();
}
// ***이 때, 멤버변수는 어차피 다 public 이어야하고 static, final이므로
// ***디폴트로 지정되어있다! (함수는 public, abstract가 디폴트!)
interface IB { // MS가 좋아하는 스타일 vs Java는 앞에 I 쓰고 ~able로 끝난다.
	int AGE = 100; // 인터페이스 내부에는 상수를 쓸 수 있다.
	String Print();
}

interface IC { // MS가 좋아하는 스타일 vs Java는 앞에 I 쓰고 ~able로 끝난다.
	void run();
}

// 인터페이스가 인터페이스 상속할 수 있다.

class Test implements IA {

	@Override
	public String Print() {
		// TODO Auto-generated method stub
		return null;
	}
}

class Test2 extends Object implements IA, IB, IC {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String Print() {
		// TODO Auto-generated method stub
		return null;
	}
}

// 인터페이스는 Spring Framework에서 많이 등장!
// 전자정부 프레임워크 https://www.egovframe.go.kr/
// 공공기관에서 사용하는 프레임워크 교육 무료 제공!

public class Ex0117_Interface {
	public static void main(String[] args) {
		// 사실 List 인터페이스를 구현한 형태이다!
		// ArrayList<String> list = new ArrayList<>(); 그래서 이 코드보다는
		List<String> list = new ArrayList<>(); // 이게 낫다.
		
		
	}
}

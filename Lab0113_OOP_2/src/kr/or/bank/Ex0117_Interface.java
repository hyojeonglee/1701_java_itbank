package kr.or.bank;

// 추상클래스 vs 인터페이스
// 1. 공통점
//		- 재정의를 통한 강제적 구현 목적
//		- 스스로 객체 생성 불가 (직접 new 못함)
//		- 상속관계에서만 사용 가능

// 2. 다른점
//		- 추상클래스 (단일상속) : 인터페이스 다중상속 가능
//		- 추상클래스 (완성된 코드 + 미완성 코드) : 인터페이스 미완성 (단 static 상수 제외)

// 추상클래스와 인터페이스 > 다형성 코드
// Interface도 하나의 타입이다.
// 서로 연관이 없는 클래스에 대해서 하나를 묶을 수 있는 기반 제공

// 게임
// 수리할 수 있는
// 유닛 : 지상 유닛, 공중 유닛

interface Irepairable {
	
}

// 공통점
class Unit2 {
	int hitpoint;
	final int MAX_HP;
	
	Unit2(int hp) {
		this.MAX_HP = hp;
	}
}

// 지상 유닛
class GroundUnit extends Unit2 {
	GroundUnit(int hp) { // 강제 구현!
		super(hp);
	}
}

// 공중 유닛
class AirUnit extends Unit2 {
	AirUnit(int hp) {
		super(hp);
	}
}

// 개별 유닛
class Tank2 extends GroundUnit implements Irepairable {
	Tank2() {
		super(50);
		this.hitpoint = this.MAX_HP;
	}

	@Override
	public String toString() {
		return "Tank2";
	}
}

class Marine2 extends GroundUnit {
	Marine2() {
		super(30);
		this.hitpoint = this.MAX_HP;
	}

	@Override
	public String toString() {
		return "Marine2";
	}
}

class CommandCenter implements Irepairable {
	
}

// 수리 담당 유닛
class Scv extends GroundUnit implements Irepairable {
	Scv() {
		super(60);
		this.hitpoint = this.MAX_HP;
	}
	// Scv만 가지는 특수화된 내용 가지고 싶음 : 수리 기능!
//	void Repair(Unit2 unit) {
//		// 충전 (this.hitpoint를 MAX_HP만큼 충전!)
//		// 이 때 Marine2는 수리되는 대상이 아니기 때문에 또다른 로직이 필요 > 귀찮음
//		// 수리가능한(Irepairable 인터페이스가 붙은) 객체를 골라내고싶다! ***
//	}
	// 해결 방법 > Irepairable의 역할 : 같은 조상(같은 타입)으로 묶어준다.
	// 문제 : Irepairable은 자기 자원이 없는데?
	void Repair(Irepairable repairunit) {
		// 해결 : 이 때 repairunit Tank 객체가 parameter로 들어왔을 경우!
//		String str = repairunit.getClass().getSimpleName();
//		switch(str) {
//		case "Tank2":
//			Tank2 t = (Tank2) repairunit;
//			break;
//		case "Marine2":
//			Marine2 m = (Marine2) repairunit;
//			break;
//		case "Scv":
//			Scv s = (Scv) repairunit;
//			break;
//		}
		// 이건 너무 귀찮다! 그래서 결론은!
		
//		Unit2 unit = (Unit2) repairunit;
//		unit.hitpoint = unit.MAX_HP;
		
		// 강사님 코드
		if(repairunit instanceof Unit2) { // 확인 과정이 필요! *** 예외 줄일 수 있다.
			Unit2 unit2 = (Unit2) repairunit; // 다운 캐스팅, 이게 포인트! *** 
			if(unit2.hitpoint != unit2.MAX_HP) {
				unit2.hitpoint=unit2.MAX_HP;
			}
		}
		else
			System.out.println("Unit2 객체가 아닙니다."); // commandcenter 걸러짐
	}
}

public class Ex0117_Interface {
	public static void main(String[] args) {
		Marine2 marine = new Marine2();
		//System.out.println(marine.hitpoint);
		marine.hitpoint -= 20;
		Scv s = new Scv();
		// s.Repair(marine);
		//System.out.println(marine.hitpoint);
		// marine이 안 되는 이유? Irepairable을 implements하지 않았기 때문!
		
		Tank2 t2 = new Tank2();
		System.out.println("탱크 생성 직후" + t2.hitpoint);
		t2.hitpoint -= 20;
		System.out.println("탱크 공격 받음" + t2.hitpoint);
		s.Repair(t2);
		System.out.println("탱크 수리 받음" + t2.hitpoint);
	}
}

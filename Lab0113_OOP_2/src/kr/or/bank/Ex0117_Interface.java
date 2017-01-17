package kr.or.bank;

// �߻�Ŭ���� vs �������̽�
// 1. ������
//		- �����Ǹ� ���� ������ ���� ����
//		- ������ ��ü ���� �Ұ� (���� new ����)
//		- ��Ӱ��迡���� ��� ����

// 2. �ٸ���
//		- �߻�Ŭ���� (���ϻ��) : �������̽� ���߻�� ����
//		- �߻�Ŭ���� (�ϼ��� �ڵ� + �̿ϼ� �ڵ�) : �������̽� �̿ϼ� (�� static ��� ����)

// �߻�Ŭ������ �������̽� > ������ �ڵ�
// Interface�� �ϳ��� Ÿ���̴�.
// ���� ������ ���� Ŭ������ ���ؼ� �ϳ��� ���� �� �ִ� ��� ����

// ����
// ������ �� �ִ�
// ���� : ���� ����, ���� ����

interface Irepairable {
	
}

// ������
class Unit2 {
	int hitpoint;
	final int MAX_HP;
	
	Unit2(int hp) {
		this.MAX_HP = hp;
	}
}

// ���� ����
class GroundUnit extends Unit2 {
	GroundUnit(int hp) { // ���� ����!
		super(hp);
	}
}

// ���� ����
class AirUnit extends Unit2 {
	AirUnit(int hp) {
		super(hp);
	}
}

// ���� ����
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

// ���� ��� ����
class Scv extends GroundUnit implements Irepairable {
	Scv() {
		super(60);
		this.hitpoint = this.MAX_HP;
	}
	// Scv�� ������ Ư��ȭ�� ���� ������ ���� : ���� ���!
//	void Repair(Unit2 unit) {
//		// ���� (this.hitpoint�� MAX_HP��ŭ ����!)
//		// �� �� Marine2�� �����Ǵ� ����� �ƴϱ� ������ �Ǵٸ� ������ �ʿ� > ������
//		// ����������(Irepairable �������̽��� ����) ��ü�� ��󳻰�ʹ�! ***
//	}
	// �ذ� ��� > Irepairable�� ���� : ���� ����(���� Ÿ��)���� �����ش�.
	// ���� : Irepairable�� �ڱ� �ڿ��� ���µ�?
	void Repair(Irepairable repairunit) {
		// �ذ� : �� �� repairunit Tank ��ü�� parameter�� ������ ���!
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
		// �̰� �ʹ� ������! �׷��� �����!
		
//		Unit2 unit = (Unit2) repairunit;
//		unit.hitpoint = unit.MAX_HP;
		
		// ����� �ڵ�
		if(repairunit instanceof Unit2) { // Ȯ�� ������ �ʿ�! *** ���� ���� �� �ִ�.
			Unit2 unit2 = (Unit2) repairunit; // �ٿ� ĳ����, �̰� ����Ʈ! *** 
			if(unit2.hitpoint != unit2.MAX_HP) {
				unit2.hitpoint=unit2.MAX_HP;
			}
		}
		else
			System.out.println("Unit2 ��ü�� �ƴմϴ�."); // commandcenter �ɷ���
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
		// marine�� �� �Ǵ� ����? Irepairable�� implements���� �ʾұ� ����!
		
		Tank2 t2 = new Tank2();
		System.out.println("��ũ ���� ����" + t2.hitpoint);
		t2.hitpoint -= 20;
		System.out.println("��ũ ���� ����" + t2.hitpoint);
		s.Repair(t2);
		System.out.println("��ũ ���� ����" + t2.hitpoint);
	}
}

// ����� ������ �ǹ� : ���뼺
// <Ư��>
// 1. ���� ��� (������ ����� ������)
// 2. extends (Ȯ��) cf. C#�� , ����.
// 3. interface�� ���� ��� ����!

// ��� ������ Point : �ڿ����� ���� �и� �̴� �����ϱ�!

// ������Ȳ. class�� ���� �� �ִ� ���
// 1. Ŭ���� ���� ���踦 �ľ��Ѵ�. => ��� or ����
//		... is a ~ : ...�� ~�̴�. => ���
//		... has a ~ : ...�� ~�� ������ �ִ�. => ����
//		ex1. ��(��üȭ�� �ڿ�)�� ����(�߻��ڿ�)�̴�. => ���
//		ex2. ���� ���̴�? (X)
// 		ex3. ���� ���� ������ �ִ�. => ����

// ex. �ﰢ��, ��, �簢�� ������ ��! ���� ���� ��Ҹ� �����غ��� ���� ����!
// 		�׷��� ���� �������� �̴´�.
// 		�������� ��Ȳ > ����, �׸��� > ����
// 		��(point) > Ŭ����
// 		class Point {}
// 		class Circle { Point p; }
// 		�̰��� ����� ���� : �� Ŭ������ �ϳ��� ����ϰ� ���������� ���� ������ ����

// ��� : �Ϲ�ȭ > ��üȭ and ���� > Ư��ȭ

// �Ϲ�ȭ(����) : Shape, Point
// ��üȭ(Ư��ȭ) : Circle(������), Triangle(���� 3��) ...

// http://www.nextree.co.kr/p6753

class Shape {
	String color = "blue";
	void draw() {
		System.out.println("�׸���");
	}
}

class Point {
	int x;
	int y;
	
	Point() {
		// *this�� ���� : ��ü �ڽ��� ����Ű�� this, �����ڸ� ȣ���ϴ� this
		// ���⼭�� �Ʒ� Point(int x, int y)�� ȣ���Ѵ�.
		this(1, 1); 
	}
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

// ���� �����̴�. (����)
// ���� ���� ������ �ִ�. (����)
class Circle extends Shape {
	// ���� ��üȭ, Ư��ȭ�� ��!
	int r; // Ư��ȭ�� Ư��! ������!
	Point center;
	
	public Circle() {
		// this.r = 100;
		// this.center = new Point(10, 10);
		this(100, new Point(10, 10));
	}
	
	public Circle(int r, Point center) {
		this.r = r;
		this.center = center;
	}
	// ���콺 ��Ŭ�� - Source - Override/implement method
	// �� �� @Override�� �Լ����� ����� �����ִ��� �˻����ش�. > ���� ���� ���̱�! 
	@Override
	void draw() {
		// TODO Auto-generated method stub
		// super.draw();
		System.out.println("���׸���");
		System.out.println("������ : " + this.r);
		System.out.println("x : y" + this.center.x + ":" + this.center.y);
	}

//	public void CircleDraw() {
//		System.out.println("���׸���");
//		System.out.println("������ : " + this.r);
//		System.out.println("x : y" + this.center.x + ":" + this.center.y);
//	}
}

// ���� 1. �ﰢ�� �����
// �ﰢ���� �����̴�
// �ﰢ���� �� ���� ���� ������ �ִ�.
// ���� ũ��, ���� ũ��

class Triangle extends Shape {
	Point[] point;
	
	public Triangle() {
		this(new Point[3]);
	}
	
	public Triangle(Point[] point) {
		for(int i = 0 ; i < point.length ; i++)
			this.point[i] = point[i];
	}
}

public class Ex0113_Inherit {
	public static void main(String[] args) {
		Circle circle = new Circle();
		circle.draw();
	}
}

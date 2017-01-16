// 상속의 진정한 의미 : 재사용성
// <특성>
// 1. 단일 상속 (계층적 상속은 가능함)
// 2. extends (확장) cf. C#은 , 쓴다.
// 3. interface는 다중 상속 가능!

// 상속 구현의 Point : 자원들의 공통 분모 뽑는 연습하기!

// 문제상황. class가 여러 개 있는 경우
// 1. 클래스 간의 관계를 파악한다. => 상속 or 포함
//		... is a ~ : ...은 ~이다. => 상속
//		... has a ~ : ...은 ~을 가지고 있다. => 포함
//		ex1. 원(구체화된 자원)은 도형(추상자원)이다. => 상속
//		ex2. 원은 점이다? (X)
// 		ex3. 원은 점을 가지고 있다. => 포함

// ex. 삼각형, 원, 사각형 구현할 때! 먼저 세부 요소를 나열해보는 것이 편함!
// 		그러고 나서 공통점을 뽑는다.
// 		공통적인 상황 > 색상, 그리다 > 도형
// 		점(point) > 클래스
// 		class Point {}
// 		class Circle { Point p; }
// 		이것이 어려운 이유 : 한 클래스가 하나만 상속하고 포함하지는 않음 여러개 가짐

// 상속 : 일반화 > 구체화 and 공통 > 특수화

// 일반화(공통) : Shape, Point
// 구체화(특수화) : Circle(반지름), Triangle(점이 3개) ...

// http://www.nextree.co.kr/p6753

class Shape {
	String color = "blue";
	void draw() {
		System.out.println("그리다");
	}
}

class Point {
	int x;
	int y;
	
	Point() {
		// *this의 종류 : 객체 자신을 가리키는 this, 생성자를 호출하는 this
		// 여기서는 아래 Point(int x, int y)를 호출한다.
		this(1, 1); 
	}
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

// 원은 도형이다. (성립)
// 원은 점을 가지고 있다. (성립)
class Circle extends Shape {
	// 원은 구체화, 특수화된 것!
	int r; // 특수화된 특성! 반지름!
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
	// 마우스 우클릭 - Source - Override/implement method
	// 이 때 @Override는 함수명이 제대로 쓰여있는지 검사해준다. > 쓰는 습관 들이기! 
	@Override
	void draw() {
		// TODO Auto-generated method stub
		// super.draw();
		System.out.println("원그리기");
		System.out.println("반지름 : " + this.r);
		System.out.println("x : y" + this.center.x + ":" + this.center.y);
	}

//	public void CircleDraw() {
//		System.out.println("원그리기");
//		System.out.println("반지름 : " + this.r);
//		System.out.println("x : y" + this.center.x + ":" + this.center.y);
//	}
}

// 문제 1. 삼각형 만들기
// 삼각형은 도형이다
// 삼각형은 세 개의 점을 가지고 있다.
// 고정 크기, 변동 크기

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

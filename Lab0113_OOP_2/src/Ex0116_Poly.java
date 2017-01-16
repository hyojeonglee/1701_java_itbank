import java.util.Scanner;

// [다형성 : 여러가지 성질(형태)을 가질 수 있는 능력!]
// 1. 오버로딩 or 오버라이딩도 MS(C#)에서는 다형성의 범주에 넣는다
// 2. java는 그렇지 않다! => [상속] 관계만 생각하기
//		- 하나의 [참조변수]가 여러 개의 타입을 가질 수 있다.
//		- 조상 클래스 타입의 참조변수로 자식 클래스 객체를 참조 가능하다.
//		- 자식은 부모에게 조건 없이 드린다~

class Tv2 { // 부모
	boolean power;
	int ch;
	
	void Power() {
		this.power = !this.power;
	}
	
	void ChUp() {
		this.ch++;
	}
	
	void ChDown() {
		this.ch--;
	}
}

class CaptionedTv extends Tv2 { // 자막 처리 가능한 TV
	String text;
	String Caption() {
		return this.text = "자막 처리";
	}
}

// 문제. 가전제품 shop
class Product {
	int pcost;
	int ppoint;
	
	public Product(int pcost) {
		this.pcost = pcost;
		this.ppoint = (int) (this.pcost / 10.0);
	}
}

class Tv extends Product {
	public Tv() {
		super(500);
	}
	
	@Override
	public String toString() {
		return this.getClass().getName();
	}
}

class Audio extends Product {
	public Audio() {
		super(300);
	}

	@Override
	public String toString() {
		return this.getClass().getName();
	}
}

class Computer extends Product {
	public Computer() {
		super(100);
	}

	@Override
	public String toString() {
		return this.getClass().getName();
	}
}

class Buyer {
	int bcost;
	int bpoint;
	String bid;
	
	public Buyer(String bid) {
		this.bcost = 1000;
		this.bpoint = 0;
		this.bid = bid;
	}
	
	// 의존 관계는 어떻게 표현?
	// Q. product 이름도 표현하고 싶은데! ***
	public void buyProduct(Product product) {
		if(this.bcost < product.pcost) {
			System.out.println("고객님의 잔액이 부족합니다^^");
			return; // 함수 탈출!
		}
		else {
			// A. 타입은 부모(product)지만 객체는 자식 객체 이므로! toString() 쓰면 된다!!! ***
			System.out.println(this.bid + "님, " + product.toString() + " 제품을 구매하였습니다.");
			this.bcost -= product.pcost;
			this.bpoint += product.ppoint;
			System.out.println("포인트 " + product.ppoint + 
					"점을 얻어 총 포인트는 " + this.bpoint + "점입니다.");
		}
	}
}

public class Ex0116_Poly {
	public static void main(String[] args) {
		CaptionedTv ctv = new CaptionedTv();
		ctv.Power();
		System.out.println(ctv.power);
		
		ctv.ChUp();
		System.out.println(ctv.ch);
		
		System.out.println(ctv.Caption());
		//----------------여기까지 기존 코드----------------//
		
		Tv2 t2 = ctv; // 이 때 업 캐스팅은 기본으로 해준다.
		// 한계 : 이 때, t2. 해도 Caption()은 보이지 않는다.
		//       부모는 자식 것에 접근하진 못한다!
		
		System.out.println(t2);
		System.out.println(ctv);
		
		t2.ChDown();
		t2.ChDown();
		System.out.println("자식이 보는 채널 정보 : " + ctv.ch);
		System.out.println("부모가 보는 채널 정보 : " + t2.ch);
		
		// Tv2 tv2 = new Tv2(); 해도 되지 않니? 굳이 있는데 안 만들어도됨
		// 사실 더 큰 문제는...
		// CaptionedTv ctv2 = t2; 이건 안됨... 부모가 자식에게 준 경우!
		// 해결 : 다운 캐스팅해준다.(또는 명시적 캐스팅)
		CaptionedTv ctv2 = (CaptionedTv) t2;
		
		//---------------가전제품---------------//
		System.out.println("---------------가전제품---------------");
		
		Tv tv = new Tv();
		Audio audio = new Audio();
		Computer computer = new Computer();
		
		Buyer[] buyer = {new Buyer("효정"), new Buyer("누리"), new Buyer("아영"), new Buyer("강사님")};
		buyer[0].buyProduct(tv);
		buyer[0].buyProduct(audio);
		System.out.println(buyer[0].bid + "님, 잔액은 " + buyer[0].bcost + "원입니다.");
	
		System.out.println("-------------------------------------");
		
		buyer[1].buyProduct(computer);
		buyer[1].buyProduct(audio);
		System.out.println(buyer[1].bid + "님, 잔액은 " + buyer[1].bcost + "원입니다.");


		boolean running = true;
		while(running){
			Scanner scan = new Scanner(System.in);
			String b_name = scan.next("이름을 입력해주세요.");
			Buyer b = new Buyer(b_name);
			String p_name = scan.next("어떤 제품을 구매하시겠습니까? (Tv, Audio, Computer / exit)");
			switch(p_name) {
			case "Tv" : 
				b.buyProduct(tv);
				break;
			case "Audio" : 
				b.buyProduct(audio);
				break;
			case "Computer" : 
				b.buyProduct(computer);
				break;
			case "exit" :
				System.out.println(b.bid + "님, 잔액은 " + b.bcost + "원입니다.");
				System.out.println("안녕히가세요");
				break;
			default :
				System.out.println("제대로 입력해주세요.");
				break;
			}
		}
	}
}

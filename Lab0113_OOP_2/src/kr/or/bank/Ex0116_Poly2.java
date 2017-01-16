package kr.or.bank;
import java.util.Scanner;
import java.util.Vector;

// 문제. 가전제품 shop
// 추가 요구 사항
// 장바구니 만들자 제품을 넣을 수 있다.
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
		return this.getClass().getSimpleName();
	}
}

class Audio extends Product {
	public Audio() {
		super(300);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
}

class Computer extends Product {
	public Computer() {
		super(100);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
}

class Buyer {
	int bcost;
	int bpoint;
	String bid;
	Vector<String> cart = new Vector<String>();
	Vector<int[]> status = new Vector<int[]>();
	Vector<String> buylist = new Vector<String>();

	public Buyer(String bid) {
		this.bcost = 1000;
		this.bpoint = 0;
		this.bid = bid;
	}
	
	public void summaryCart() {
		System.out.println("***카트에 담긴 상품은 총 " + cart.size() + "개 입니다.");
		for(int i = 0 ; i < this.cart.size() ; i++) {
			System.out.println((i+1) + ". " + this.cart.get(i));
		}
		System.out.println("***구매 목록입니다.");
		for(int i = 0 ; i < this.buylist.size() ; i++) {
			System.out.println("[" + (i+1) + "]");
			System.out.println("물건 : " + this.buylist.get(i));
			System.out.println("현재 잔액 : " + this.status.get(i)[0]);
			System.out.println("현재 포인트 : " + this.status.get(i)[1]);
			System.out.println("--------------");
		}
	}
	
	public void insertToCart(Product product) {
		System.out.println(product.toString() + "을 장바구니에 넣었습니다.");
		this.cart.add(product.toString());
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
			System.out.println("현재 잔액은 " + this.bcost + "이고, ");
			this.bpoint += product.ppoint;
			System.out.println("포인트 " + product.ppoint + 
					"점을 얻어 총 포인트는 " + this.bpoint + "점입니다.");
			int[] temp = {this.bcost, this.bpoint};
			this.buylist.add(product.toString());
			this.status.add(temp);
		}
	}
}

public class Ex0116_Poly2 {
	public static void main(String[] args) {
		Tv tv = new Tv();
		Audio audio = new Audio();
		Computer computer = new Computer();
		
		boolean running = true;
		Scanner scan = new Scanner(System.in);
		System.out.print("안녕하세요. \n고객님의 이름을 입력해주세요 : ");
		String b_name = scan.next();
		Buyer b = new Buyer(b_name);
		while(running) {
			System.out.println("메뉴를 선택하세요.\n(1)Tv 구매 / 2)Audio 구매 / 3)Computer 구매 / 4)cart / 5)exit)");
			int s = scan.nextInt();
			switch(s) {
			case 1 : 
				b.buyProduct(tv);
				break;
			case 2 : 
				b.buyProduct(audio);
				break;
			case 3 : 
				b.buyProduct(computer);
				break;
			case 4 :
				System.out.println("장바구니에 넣을 상품을 입력하세요. (Tv, Audio, Computer)");
				String temp = scan.next();
				b.insertToCart(temp.equals("Tv")? tv : (temp.equals("Audio")? audio : computer));
				break;
			case 5 :
				System.out.println(b.bid + "님, 잔액은 " + b.bcost + "원입니다.");
				b.summaryCart();
				System.out.println("안녕히가세요!");
				running = false;
				break;
			default : 
				System.out.println("메뉴를 다시 입력해주세요!");
				break;
			}
		}
	}
}

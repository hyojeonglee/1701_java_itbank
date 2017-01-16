package kr.or.bank;
import java.util.Scanner;
import java.util.Vector;

// ����. ������ǰ shop
// �߰� �䱸 ����
// ��ٱ��� ������ ��ǰ�� ���� �� �ִ�.
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
		System.out.println("***īƮ�� ��� ��ǰ�� �� " + cart.size() + "�� �Դϴ�.");
		for(int i = 0 ; i < this.cart.size() ; i++) {
			System.out.println((i+1) + ". " + this.cart.get(i));
		}
		System.out.println("***���� ����Դϴ�.");
		for(int i = 0 ; i < this.buylist.size() ; i++) {
			System.out.println("[" + (i+1) + "]");
			System.out.println("���� : " + this.buylist.get(i));
			System.out.println("���� �ܾ� : " + this.status.get(i)[0]);
			System.out.println("���� ����Ʈ : " + this.status.get(i)[1]);
			System.out.println("--------------");
		}
	}
	
	public void insertToCart(Product product) {
		System.out.println(product.toString() + "�� ��ٱ��Ͽ� �־����ϴ�.");
		this.cart.add(product.toString());
	}
	
	// ���� ����� ��� ǥ��?
	// Q. product �̸��� ǥ���ϰ� ������! ***
	public void buyProduct(Product product) {
		if(this.bcost < product.pcost) {
			System.out.println("������ �ܾ��� �����մϴ�^^");
			return; // �Լ� Ż��!
		}
		else {
			// A. Ÿ���� �θ�(product)���� ��ü�� �ڽ� ��ü �̹Ƿ�! toString() ���� �ȴ�!!! ***
			System.out.println(this.bid + "��, " + product.toString() + " ��ǰ�� �����Ͽ����ϴ�.");
			this.bcost -= product.pcost;
			System.out.println("���� �ܾ��� " + this.bcost + "�̰�, ");
			this.bpoint += product.ppoint;
			System.out.println("����Ʈ " + product.ppoint + 
					"���� ��� �� ����Ʈ�� " + this.bpoint + "���Դϴ�.");
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
		System.out.print("�ȳ��ϼ���. \n������ �̸��� �Է����ּ��� : ");
		String b_name = scan.next();
		Buyer b = new Buyer(b_name);
		while(running) {
			System.out.println("�޴��� �����ϼ���.\n(1)Tv ���� / 2)Audio ���� / 3)Computer ���� / 4)cart / 5)exit)");
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
				System.out.println("��ٱ��Ͽ� ���� ��ǰ�� �Է��ϼ���. (Tv, Audio, Computer)");
				String temp = scan.next();
				b.insertToCart(temp.equals("Tv")? tv : (temp.equals("Audio")? audio : computer));
				break;
			case 5 :
				System.out.println(b.bid + "��, �ܾ��� " + b.bcost + "���Դϴ�.");
				b.summaryCart();
				System.out.println("�ȳ���������!");
				running = false;
				break;
			default : 
				System.out.println("�޴��� �ٽ� �Է����ּ���!");
				break;
			}
		}
	}
}

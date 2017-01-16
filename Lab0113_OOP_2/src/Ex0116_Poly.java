import java.util.Scanner;

// [������ : �������� ����(����)�� ���� �� �ִ� �ɷ�!]
// 1. �����ε� or �������̵��� MS(C#)������ �������� ���ֿ� �ִ´�
// 2. java�� �׷��� �ʴ�! => [���] ���踸 �����ϱ�
//		- �ϳ��� [��������]�� ���� ���� Ÿ���� ���� �� �ִ�.
//		- ���� Ŭ���� Ÿ���� ���������� �ڽ� Ŭ���� ��ü�� ���� �����ϴ�.
//		- �ڽ��� �θ𿡰� ���� ���� �帰��~

class Tv2 { // �θ�
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

class CaptionedTv extends Tv2 { // �ڸ� ó�� ������ TV
	String text;
	String Caption() {
		return this.text = "�ڸ� ó��";
	}
}

// ����. ������ǰ shop
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
			this.bpoint += product.ppoint;
			System.out.println("����Ʈ " + product.ppoint + 
					"���� ��� �� ����Ʈ�� " + this.bpoint + "���Դϴ�.");
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
		//----------------������� ���� �ڵ�----------------//
		
		Tv2 t2 = ctv; // �� �� �� ĳ������ �⺻���� ���ش�.
		// �Ѱ� : �� ��, t2. �ص� Caption()�� ������ �ʴ´�.
		//       �θ�� �ڽ� �Ϳ� �������� ���Ѵ�!
		
		System.out.println(t2);
		System.out.println(ctv);
		
		t2.ChDown();
		t2.ChDown();
		System.out.println("�ڽ��� ���� ä�� ���� : " + ctv.ch);
		System.out.println("�θ� ���� ä�� ���� : " + t2.ch);
		
		// Tv2 tv2 = new Tv2(); �ص� ���� �ʴ�? ���� �ִµ� �� ������
		// ��� �� ū ������...
		// CaptionedTv ctv2 = t2; �̰� �ȵ�... �θ� �ڽĿ��� �� ���!
		// �ذ� : �ٿ� ĳ�������ش�.(�Ǵ� ����� ĳ����)
		CaptionedTv ctv2 = (CaptionedTv) t2;
		
		//---------------������ǰ---------------//
		System.out.println("---------------������ǰ---------------");
		
		Tv tv = new Tv();
		Audio audio = new Audio();
		Computer computer = new Computer();
		
		Buyer[] buyer = {new Buyer("ȿ��"), new Buyer("����"), new Buyer("�ƿ�"), new Buyer("�����")};
		buyer[0].buyProduct(tv);
		buyer[0].buyProduct(audio);
		System.out.println(buyer[0].bid + "��, �ܾ��� " + buyer[0].bcost + "���Դϴ�.");
	
		System.out.println("-------------------------------------");
		
		buyer[1].buyProduct(computer);
		buyer[1].buyProduct(audio);
		System.out.println(buyer[1].bid + "��, �ܾ��� " + buyer[1].bcost + "���Դϴ�.");


		boolean running = true;
		while(running){
			Scanner scan = new Scanner(System.in);
			String b_name = scan.next("�̸��� �Է����ּ���.");
			Buyer b = new Buyer(b_name);
			String p_name = scan.next("� ��ǰ�� �����Ͻðڽ��ϱ�? (Tv, Audio, Computer / exit)");
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
				System.out.println(b.bid + "��, �ܾ��� " + b.bcost + "���Դϴ�.");
				System.out.println("�ȳ���������");
				break;
			default :
				System.out.println("����� �Է����ּ���.");
				break;
			}
		}
	}
}

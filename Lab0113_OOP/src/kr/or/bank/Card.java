package kr.or.bank;

public class Card {
	public int number;
	public String kind;
	
	public int h = 10;
	public int w = 20;
	
	public void card_Info() {
		System.out.println("");
	}
	
	// 이 때 만들어진 카드 객체 52장의 h, w 값을 한 번에 바꾸려면?
	// h와 w를 static 변수로 만들었어야함
}

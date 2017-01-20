package kr.or.bank;

import java.util.Scanner;
import javax.swing.JOptionPane;

//구구단 게임
//단어 게임
//입력시간 게임 종료


class Timer extends Thread{

	@Override
	public void run() {
		for(int i=20; i>0; i--){
			System.out.println("남은 시간: "+i);
			
			try{
				Thread.sleep(1000);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
}


public class Ex05_Quiz_game {

	public static void main(String[] args) {
		
		
		
		
		System.out.println("게임을 선택하세요");
		System.out.println("1. 구구단  2. 단어게임  3.종료");
		Scanner scan = new Scanner(System.in);
		
		switch(scan.nextInt()){
			case 1:
				GuGuDan();
				break;
			case 2:
				WordGame();
				break;
			case 3:
				System.out.println("종료되었습니다.");
				System.exit(0);
		}
		
		
		
	}
	
	
	
	private static void GuGuDan(){
		
		Timer gugu = new Timer();
		gugu.start();
		
		while(gugu.isAlive()){
			
			int x = (int) (Math.random()*9+1);
			int y = (int) (Math.random()*9+1);
			
			String inputdata = JOptionPane.showInputDialog(x+"*"+y+"= ?");	//Swing의 값을 입력받는 창
			System.out.println("당신이 입력한 값은: "+inputdata);
		
			if(Integer.parseInt(inputdata)!=x*y){
				System.out.println("틀렸습니다.");
				System.exit(0);
			}else
				System.out.println("맞았습니다.");
			
			try {
				gugu.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	private static void WordGame(){
		Timer wordgame = new Timer();
		wordgame.start();
		
		
		
		String ans[] = {"햄버거", "피자", "치킨", "콜라", "빵"};
		
		while(wordgame.isAlive()){
			int k = (int) (Math.random()*4);
			String inputdata = JOptionPane.showInputDialog(ans[k]);	//Swing의 값을 입력받는 창
			
			if(inputdata.equals(ans[k]))
				System.out.println("맞았습니다.");
			else
				System.out.println("틀렸습니다.");
			
			try {
				wordgame.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	
	

}

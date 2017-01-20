package kr.or.bank;

import java.util.Scanner;
import javax.swing.JOptionPane;

//������ ����
//�ܾ� ����
//�Է½ð� ���� ����


class Timer extends Thread{

	@Override
	public void run() {
		for(int i=20; i>0; i--){
			System.out.println("���� �ð�: "+i);
			
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
		
		
		
		
		System.out.println("������ �����ϼ���");
		System.out.println("1. ������  2. �ܾ����  3.����");
		Scanner scan = new Scanner(System.in);
		
		switch(scan.nextInt()){
			case 1:
				GuGuDan();
				break;
			case 2:
				WordGame();
				break;
			case 3:
				System.out.println("����Ǿ����ϴ�.");
				System.exit(0);
		}
		
		
		
	}
	
	
	
	private static void GuGuDan(){
		
		Timer gugu = new Timer();
		gugu.start();
		
		while(gugu.isAlive()){
			
			int x = (int) (Math.random()*9+1);
			int y = (int) (Math.random()*9+1);
			
			String inputdata = JOptionPane.showInputDialog(x+"*"+y+"= ?");	//Swing�� ���� �Է¹޴� â
			System.out.println("����� �Է��� ����: "+inputdata);
		
			if(Integer.parseInt(inputdata)!=x*y){
				System.out.println("Ʋ�Ƚ��ϴ�.");
				System.exit(0);
			}else
				System.out.println("�¾ҽ��ϴ�.");
			
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
		
		
		
		String ans[] = {"�ܹ���", "����", "ġŲ", "�ݶ�", "��"};
		
		while(wordgame.isAlive()){
			int k = (int) (Math.random()*4);
			String inputdata = JOptionPane.showInputDialog(ans[k]);	//Swing�� ���� �Է¹޴� â
			
			if(inputdata.equals(ans[k]))
				System.out.println("�¾ҽ��ϴ�.");
			else
				System.out.println("Ʋ�Ƚ��ϴ�.");
			
			try {
				wordgame.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	
	

}

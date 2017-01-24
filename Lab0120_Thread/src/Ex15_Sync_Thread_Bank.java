//은행 계좌
//은행 입금  . 출금
//여러명이 동시에 같은 계좌에 입출금 처리

//출금(동시에 여러명 하나의 계좌에서 출금처리)
class Account{
	int balance = 1000;//잔액
	
	//출금처리
	public  synchronized void withDraw(int money){
		//잔액 체크 
		//Thread.sleep(100) 
		//잔액 감소
		System.out.println("고객 :" + Thread.currentThread().getName());
		System.out.println("현재 잔액 : " + this.balance);
		if(balance >= money){
			try{
				Thread.sleep(100);
			}catch (Exception e) {
				
			}
			balance -= money;
		}
		System.out.println("인출금액 : " + money);
		System.out.println("인출 후 잔액 : " + this.balance);
	}
}
class Bank implements Runnable{
	Account acc = new Account();
	@Override
	public void run() {
		//실 출금처리 (랜덤하게 > 100 ~ 300 ) 
		while(acc.balance > 0){
			int money = ((int)Math.random()*3+1)*100;
			acc.withDraw(money);
		}
	}
}
public class Ex15_Sync_Thread_Bank {
	public static void main(String[] args) {
		Bank bank = new Bank();
		
			Thread th = new Thread(bank,"park");
			Thread th2 = new Thread(bank,"kim");
			Thread th3 = new Thread(bank,"lee");

			th.start();
			th2.start();
			th3.start();
			
			
	}

}

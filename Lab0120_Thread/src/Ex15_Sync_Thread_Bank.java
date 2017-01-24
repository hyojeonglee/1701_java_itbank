//���� ����
//���� �Ա�  . ���
//�������� ���ÿ� ���� ���¿� ����� ó��

//���(���ÿ� ������ �ϳ��� ���¿��� ���ó��)
class Account{
	int balance = 1000;//�ܾ�
	
	//���ó��
	public  synchronized void withDraw(int money){
		//�ܾ� üũ 
		//Thread.sleep(100) 
		//�ܾ� ����
		System.out.println("�� :" + Thread.currentThread().getName());
		System.out.println("���� �ܾ� : " + this.balance);
		if(balance >= money){
			try{
				Thread.sleep(100);
			}catch (Exception e) {
				
			}
			balance -= money;
		}
		System.out.println("����ݾ� : " + money);
		System.out.println("���� �� �ܾ� : " + this.balance);
	}
}
class Bank implements Runnable{
	Account acc = new Account();
	@Override
	public void run() {
		//�� ���ó�� (�����ϰ� > 100 ~ 300 ) 
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

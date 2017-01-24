//Multi ������ : ����ȭ
//Thread (����ȭ : �����ڿ�)
//�Ѱ�������� > ��Ż > ����ȭ��� > ������ > lock 
//�Ѱ� ���� ����� (100�κ�) > �����ڿ� > lock ��ȿ����

class Wroom {
	//synchronized ������ ����ȭ ���� 
	//���ٰ� ���� open > �Լ� ���� �۾��� ���������� > ������ ���
	public  synchronized void OpenDoor(String name){
		System.out.println(name + "�� ȭ��� ���� ^^");
		for(int i = 0 ; i < 10000 ; i++){
			if(i == 1000){
				System.out.println(name + "�� �� !");
			}
		}
		System.out.println(name + "�� �ÿ� �ÿ� ");
	}
}
class Users extends Thread{
	private Wroom wr;
	private String who;
	
	public Users(String name, Wroom wr){
		this.who = name;
		this.wr = wr;
	}
	
	@Override
	public void run(){
		wr.OpenDoor(this.who);
	}
	
}

public class Ex12_Sync_Thread {
	public static void main(String[] args) {
		//�Ѱ���ġ
		Wroom w = new Wroom();
		
		Users kim = new Users("�达", w);
		Users park = new Users("�ھ�", w);
		Users lee  = new Users("�̾�", w);
		
		kim.start();
		park.start();
		lee.start();
	}

}

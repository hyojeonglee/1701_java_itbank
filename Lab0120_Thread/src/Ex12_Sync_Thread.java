//Multi 쓰레드 : 동기화
//Thread (동기화 : 공유자원)
//한강고수부지 > 배탈 > 공중화장실 > 문열고 > lock 
//한강 음식 비빕밥 (100인분) > 공유자원 > lock 비효율적

class Wroom {
	//synchronized 쓰레드 동기화 보장 
	//누근가 먼저 open > 함수 내의 작업이 끝날떄까지 > 나머지 대기
	public  synchronized void OpenDoor(String name){
		System.out.println(name + "님 화장실 입장 ^^");
		for(int i = 0 ; i < 10000 ; i++){
			if(i == 1000){
				System.out.println(name + "님 끙 !");
			}
		}
		System.out.println(name + "님 시원 시원 ");
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
		//한강둔치
		Wroom w = new Wroom();
		
		Users kim = new Users("김씨", w);
		Users park = new Users("박씨", w);
		Users lee  = new Users("이씨", w);
		
		kim.start();
		park.start();
		lee.start();
	}

}

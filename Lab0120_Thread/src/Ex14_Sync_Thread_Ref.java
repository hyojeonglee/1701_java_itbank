class Data{
	int iv = 0;
}
class MyThreadData extends Thread{
	Data d;
	
	public MyThreadData(Data d){
		this.d = d;
	}
	
	@Override
	public void run(){
		int lv=0;
		while(lv < 3){
			System.out.println(this.getName() + " local var : " + ++lv);
			System.out.println(this.getName() + " instance var : " + ++d.iv);
			System.out.println();
		}
	}
}

public class Ex14_Sync_Thread_Ref {

	public static void main(String[] args) {
		Data d = new Data();
		MyThreadData th = new MyThreadData(d); //xx����
		MyThreadData th2 = new MyThreadData(d); //xx����
		
		th.start();
		th2.start();

	}

}

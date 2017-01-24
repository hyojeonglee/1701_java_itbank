import java.util.Calendar;

import javax.swing.JFrame;

public class Ex11_Thread extends JFrame implements Runnable {
	public Ex11_Thread(){
		super("Timer입니다");
		this.setSize(400, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		Thread timer = new Thread(new Ex11_Thread());
		timer.start();
	}

	@Override
	public void run() {
		while(true){
			Calendar cal = Calendar.getInstance(); //현재 시스템 날짜 형식
			String now = cal.get(Calendar.YEAR) + "년" +
						 cal.get(Calendar.MONTH +1) + "월" +
					     cal.get(Calendar.DATE) + "일" + 
						 cal.get(Calendar.HOUR) + "시" + 
					     cal.get(Calendar.MINUTE) + "분" + 
						 cal.get(Calendar.SECOND);
			       super.setTitle(now);
			       
			       try{
			    	   Thread.sleep(1000);
			       }catch(Exception e){
			    	   e.printStackTrace();
			       }
		}
		
	}

}






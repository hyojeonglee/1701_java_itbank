import java.util.Calendar;

import javax.swing.JFrame;

public class Ex11_Thread extends JFrame implements Runnable {
	public Ex11_Thread(){
		super("Timer�Դϴ�");
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
			Calendar cal = Calendar.getInstance(); //���� �ý��� ��¥ ����
			String now = cal.get(Calendar.YEAR) + "��" +
						 cal.get(Calendar.MONTH +1) + "��" +
					     cal.get(Calendar.DATE) + "��" + 
						 cal.get(Calendar.HOUR) + "��" + 
					     cal.get(Calendar.MINUTE) + "��" + 
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






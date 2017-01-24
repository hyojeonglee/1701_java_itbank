import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

//�ϼ�
//��� : inner class ��� Thread (ClientSend , ClientReceive)
public class Ex05_TCP_Chatt_Client {
	Socket socket;
	public Ex05_TCP_Chatt_Client(){
		try{
			socket = new Socket("192.168.101.1", 9999);
			System.out.println("������  ����Ǿ����ϴ�");
			
			new ClientSend().start();
			new ClientReceive().start();
		}catch(Exception e){
			
		}
	}
	
	//Inner class ���·� ó��(Outer class �ڿ��� Inner class ��밡��)
	class ClientSend extends Thread{
		@Override
		public void run(){
			try{
				BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
				PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
				while(true){
					String data = br.readLine();
					if(data.equals("exit")) break;
					pw.println(data); //���� ������ write
				}
				System.out.println("Client Send �۾� ����");
			}catch(Exception e){
				
			}
		}
	}
	//Inner class
	class ClientReceive extends Thread{
		
		@Override
		public void run(){
			BufferedReader br = null;
			try{
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String data = null;
				while((data = br.readLine()) != null){
					System.out.println("server���� ���� �޽��� :" + data);
				}
				System.out.println("ClientReceive �۾� ����");
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}
	public static void main(String[] args) {
		Ex05_TCP_Chatt_Client client = new Ex05_TCP_Chatt_Client();

	}

}

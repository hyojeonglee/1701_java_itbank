import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

//완성
//대신 : inner class 사용 Thread (ClientSend , ClientReceive)
public class Ex05_TCP_Chatt_Client {
	Socket socket;
	public Ex05_TCP_Chatt_Client(){
		try{
			socket = new Socket("192.168.101.1", 9999);
			System.out.println("서버와  연결되었습니다");
			
			new ClientSend().start();
			new ClientReceive().start();
		}catch(Exception e){
			
		}
	}
	
	//Inner class 형태로 처리(Outer class 자원을 Inner class 사용가능)
	class ClientSend extends Thread{
		@Override
		public void run(){
			try{
				BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
				PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
				while(true){
					String data = br.readLine();
					if(data.equals("exit")) break;
					pw.println(data); //서버 쪽으로 write
				}
				System.out.println("Client Send 작업 종료");
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
					System.out.println("server부터 받은 메시지 :" + data);
				}
				System.out.println("ClientReceive 작업 종료");
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}
	public static void main(String[] args) {
		Ex05_TCP_Chatt_Client client = new Ex05_TCP_Chatt_Client();

	}

}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Ex05_TCP_Chatt_Client {
	Socket socket = null;
	
	public Ex05_TCP_Chatt_Client() {
		try {
			socket = new Socket("192.168.101.1", 9999);
			System.out.println("서버와 연결되었습니다.");
			
			new ClientSend().start();
			new ClientReceive().start();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	// Thread를 innerClass 형태로 처리할 것!
	// (Outer Class에 있는 자원을 InnerClass가 사용할 수 있다.)
	
	// Writer
	class ClientSend extends Thread {
		@Override
		public void run() {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
				while(true) {
					String data = br.readLine();
					if(data.equals("exit")) break;
					pw.println(data);
				}
				System.out.println("Client Send 작업 종료!");
			} catch(Exception e) {
				
			}
		}
	}
	
	// Read
	class ClientReceive extends Thread {
		@Override
		public void run() {
			BufferedReader br = null;
			try {
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String data = null;
				while((data = br.readLine()) != null) {
					System.out.println("Server로부터 받은 메시지 : [" + data + "]");
				}
				// System.out.println("Client Receiver 작업 종료!");
			} catch(Exception e) {
				 System.out.println(e.getMessage());
			}
		}
	}
	
	public static void main(String[] args) {
		Ex05_TCP_Chatt_Client e = new Ex05_TCP_Chatt_Client();
	}
}

import java.net.Socket;

public class Ex06_TCP_Chatt_Client {

	public static void main(String[] args) {
		Socket socket = null;
		try{
			socket = new Socket("192.168.137.1", 9999);
			System.out.println("서버와  연결되었습니다");
			Sender sen = new Sender(socket);
			Receiver rev = new Receiver(socket);
			
			sen.start();
			rev.start();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}

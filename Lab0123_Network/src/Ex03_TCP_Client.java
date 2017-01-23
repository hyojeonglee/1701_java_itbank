import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Ex03_TCP_Client {

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		Socket socket = new Socket("192.168.101.1", 7777);
		System.out.println("서버와 연결되었습니다.");
		
		// 서버로부터 받은 메시지!
		InputStream in = socket.getInputStream();
		DataInputStream dis = new DataInputStream(in);
		
		String servermsg = dis.readUTF();
		System.out.println("서버로부터 받은 메시지 : " + servermsg);
		dis.close();
		in.close();
		socket.close();
	}

}

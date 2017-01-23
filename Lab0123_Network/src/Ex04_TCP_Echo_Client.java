import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Ex04_TCP_Echo_Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("192.168.101.1", 9999);
		System.out.println("서버와 연결되었습니다.");
		Scanner scan = new Scanner(System.in);
		
		// 서버 socket과 통신해야함. (read, write)
		// read 준비 : 다형성으로 코드 량을 줄였다.
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		
		// write 준비
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		
		while(true) {
			System.out.println("Go!");
			System.out.print("문자열을 입력해주세요 : ");
			String servermsg = scan.next();
			// String servermsg = dis.readUTF(); // 읽을 것이 없으면 진행하지 않는다.
			System.out.println("Server Msg : " + servermsg);
			
			// 메아리 기능
			dos.writeUTF(servermsg);
			
			if(servermsg.equals("exit")) break; // 서버 종료
			
			dos.flush();
		}
		System.out.println("클라이언트 종료");
		dis.close();
		dos.close();
		socket.close();
	}

}

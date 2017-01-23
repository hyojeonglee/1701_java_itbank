import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

// 코드 패턴은 비슷하다.

// 에코 서버
// 구상
// 1. 서버는 accept해서 대기상태
// 2. 클라이언트는 서버 IP랑 서버포트를 알고, 소켓 생성
// 3. 양 쪽에 input, output 모두 구현되어야한다.
public class Ex04_TCP_Echo_Server {

	public static void main(String[] args) throws IOException, EOFException {
		ServerSocket serverSocket = new ServerSocket(9999);
		System.out.println("클라이언트 접속 대기 중");
		Socket socket = serverSocket.accept();
		
		// 클라이언트 socket과 통신해야함. (read, write)
		// read 준비
		InputStream in = socket.getInputStream();
		DataInputStream dis = new DataInputStream(in);
		
		// write 준비
		OutputStream out = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(out);
		
		while(true) {
			System.out.println("Go!");
			String clientmsg = dis.readUTF(); // 읽을 것이 없으면 진행하지 않는다.
			System.out.println("Client Msg : " + clientmsg);
		
			// 같은 내용을 Client에게 write해준다.
			if(clientmsg.equals("exit")) break; // 서버 종료
			
			// 메아리 기능
			dos.writeUTF(clientmsg);
			dos.flush();
		}
		System.out.println("클라이언트 exit 문자 : 서버 종료");
		dis.close();
		dos.close();
		in.close();
	}

}

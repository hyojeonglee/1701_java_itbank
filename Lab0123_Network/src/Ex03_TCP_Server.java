import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

// 서버의 필수 요소 : 자기의 IP, 포트번호
// ServerSocket 생성 > 클라이언트의 요청 대기

public class Ex03_TCP_Server {
	public static void main(String[] args) throws Exception {
		 ServerSocket serverSocket = new ServerSocket(7777);
		 String str = "문자 데이터와 데이터 통신";
		 System.out.println("서버정보 : " + serverSocket.getInetAddress());
		 System.out.println("서버 접속 대기중 ...");
		 
		 Socket socket = serverSocket.accept(); // 응답 대기 > 연결 socket 생성
		 System.out.println("연결");
		 //////////////////////////////////////////////
		 // server => client
		 // ★Socket은 내부적으로 Stream을 구현하고 있다.
		 OutputStream out = socket.getOutputStream();
		 DataOutputStream dos = new DataOutputStream(out);
		 dos.writeUTF("str"); // 접속한 클라이언트에 write 보내기
		 //////////////////////////////////////////////
		 
		 System.out.println("서버 종료");
		 
		 dos.close();
		 out.close();
		 socket.close();
		 serverSocket.close();
	}
}

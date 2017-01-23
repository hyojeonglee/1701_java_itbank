import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//<코드 최적화시에 고려할 점>
//1. 이 때, 읽고쓰는 주체는 소켓이다! send랑 receive 클래스가 소켓자원을 써야한다.
// 그런데 다른 클래스 내에 있어서 쓸 수 없다.
// > 해결 : 의존 or 연관

// 서버-클라이언트 1대1 통신
// 서버 : read, write
// 클라이언트 : read, write
// 이전처럼 순차처리가 아니고 read와 write가 동시에 수행되어야한다 > Thread!!!

public class Ex05_TCP_Chatt_Server {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(9999);
			System.out.println("접속 대기 중...");
			socket = serverSocket.accept();
			
			// 기존 코드 : inputStream, outputStream으로 Socket이라는 객체를 얻음
			// socket.get..., socket.get~
			
			// 위 작업을 send와 receive class가 진행한다.
			// 그러려면 Socket의 주소값을 참조해야한다.
		
			// Thread 2개가 돌아간다.
			new ServerSend(socket).start();
			new ServerReceive(socket).start();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				serverSocket.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

class ServerSend extends Thread {
	Socket socket = null;
	
	public ServerSend(Socket socket) {
		this.socket = socket;
	}
	
	// 이 생성자 코드를 없애고 싶으면??? Inner Class로 바꾸어준다.
	
	@Override
	public void run() {
		try { 
			// socket으로부터 얻은 OutputStream 처리
			// console에서 입력한 값을 받아서 출력 스트림을 통해 Client에게 전달
			
			// 입력처리 : 스캐너 대신 br사용! (사실 스캐너 내부가 저렇게 생겼음)
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			// 출력처리 : 보조스트림 PrintWriter 사용! 출력 포맷을 정하는게 편하다.
			// 다른방법 : 
			// OutputStream out = socket.getOutputStream();
			// DataOutputStream dos = new DataOutputStream(out);
			// 이것은 8가지 타입으로 output 가능!
			PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
			
			while(true) {
				String data = br.readLine(); // s.nextLine();
				if(data.equals("exit")) break;
				pw.println(data); // == dos.writeUTF("");
			}
			System.out.println("Server Send 작업 종료!");
		} catch(Exception e) {
			
		}
		
	}
}

class ServerReceive extends Thread {
	Socket socket = null;
	
	public ServerReceive(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		BufferedReader br = null; // Line단위 데이터 처리!
		try {
			// br = new BufferedReader(socket.getInputStream()); 불가능!
			// 외우지 않으면 모름!
			// InputStreamReader 사용 방법(Stream => Reader 변환)
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String data = null;
			while((data = br.readLine()) != null) {
				System.out.println("Client로부터 받은 메시지 : [" + data + "]");
				// 나중에 awt나 swing으로 바꾸어주자! 콘솔에서는 오류남
			}
			// System.out.println("Server Receiver 작업 종료");
		} catch(Exception e) {
			 System.out.println(e.getMessage());
		}
//		try { 
//			InputStream in = socket.getInputStream();
//			DataInputStream dis = new DataInputStream(in);
//		
//			while(true) {
//				String clientmsg = dis.readUTF();
//				System.out.println("Client Msg : " + clientmsg);
//			
//				if(clientmsg.equals("exit")) break; // 서버 종료
//			}
//			System.out.println("Server Receive 작업 종료!");
//		} catch(Exception e) {
//			
//		}
	}
}
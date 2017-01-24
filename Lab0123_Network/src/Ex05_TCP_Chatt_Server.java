import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//서버 : 클라이언트 (1:1 통신)
//서버 : read / write
//클라이언트 : read / write
//Ex03 ~ Ex04 > 순차적인 처리
//동시에 read , write
//read 동작, write 동작 > Thread 사용

public class Ex05_TCP_Chatt_Server {

	public static void main(String[] args) {
		ServerSocket serversocket = null;
		try{
			serversocket = new ServerSocket(9999);
			System.out.println("접속 대기중...");
			Socket socket = serversocket.accept();
			
			//기존
			//inputStream , outputStream 으로 Socket 이라는 객체
			
			//ServerSend , ServerReveive 클래스 (Socket 녀석의 주속값 참조)
			//socket.get...
			//socket.get...
			
			//ServerSend s = new ServerSend(socket);
			//s.start()
			
			//ServerSend send = new ServerSend(socket);
			//send.start();
			new ServerSend(socket).start();
			new ServerReceive(socket).start();
			
		}catch(Exception e){
			
		}finally {
			try {
				serversocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
//고민 : ServerSend , ServerReveive > socket 자원(주소)
//write
class ServerSend extends Thread{
	Socket socket;
	public ServerSend(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run(){
		try{
			//socket 으로 부터얻은 outputstream 처리
			//Console에서 입력한 값을 받아서 출력스트림을 통해서 Client 전달
			
			//Scanner 대신
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			//출력처리 (PrintWriter 보조 형식 정의)
			PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
			//OutputStream out = socket.getOutputStream();
			//DataOutputStream dos = new DataOutputStream(out);
			
			while(true){
				String data = br.readLine(); //s.nextLine()
				if(data.equals("exit")) break;
				pw.println(data); // dos.writeUTF("")
			}
			System.out.println("Server Send 작업종료");
			
		}catch(Exception e){
			
		}
		
		
	}
}

//read 
//아래 코드 완성하세요 (10분)

class ServerReceive extends Thread{
	Socket socket;
	public ServerReceive(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run(){
		BufferedReader br = null; //Line 단위 데이터 처리
		try{
			//InputStreamReader 사용 방법(Stream -> Reader)
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String data = null;
			while((data = br.readLine()) != null){
				System.out.println("Client 부터 받은 메시지 : [" + data + "]");
			}
			System.out.println("Server Receive 작업종료");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
}










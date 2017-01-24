import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//어제 작성하신 Ex05_TCP_Chatt_Server 프로그램을
//DataInputStream , DataOutputStream 사용하는 것으로 바꾸세요 (보조) : 8가지 기본 :
//readUTF() , writeUTF()
//시간 20분 정도
public class Ex06_TCP_Chatt_Server_DataStream {

	public static void main(String[] args){
		ServerSocket serversocket = null;
		Socket socket = null;
		try {
			   serversocket = new ServerSocket(9999);
			   System.out.println("Server Start");
			   socket = serversocket.accept();
			   System.out.println("[" + socket.getInetAddress() + "]" + "입장");
			   
			   //데이터 read / write
			   Sender sen = new Sender(socket);
			   Receiver rev = new Receiver(socket);
			   
			   sen.start();
			   rev.start();
			   
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				serversocket.close();
				//socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
class Sender extends Thread{
	Socket socket;
	DataOutputStream out; // point
	String name;
	public Sender(Socket socket){
		this.socket = socket;
		try{
			 //socket 객체로부터 (출력객체)
			out = new DataOutputStream(socket.getOutputStream());
			name = "**" + socket.getInetAddress() + ":" + socket.getPort() +"**";
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@Override
	public void run(){
		Scanner s = new Scanner(System.in);
		while(out != null){
			try{
				//String msg = s.nextLine();
				out.writeUTF(name + " " + s.nextLine());
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
class Receiver extends Thread{
	Socket socket;
	DataInputStream in;
	public Receiver(Socket socket){
		this.socket = socket;
		try{
			in = new DataInputStream(socket.getInputStream());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	@Override
	public void run(){
		String msg ="";
		try{
			while((msg = in.readUTF()) != null){
				System.out.println(msg);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}






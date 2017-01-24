import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//���� �ۼ��Ͻ� Ex05_TCP_Chatt_Server ���α׷���
//DataInputStream , DataOutputStream ����ϴ� ������ �ٲټ��� (����) : 8���� �⺻ :
//readUTF() , writeUTF()
//�ð� 20�� ����
public class Ex06_TCP_Chatt_Server_DataStream {

	public static void main(String[] args){
		ServerSocket serversocket = null;
		Socket socket = null;
		try {
			   serversocket = new ServerSocket(9999);
			   System.out.println("Server Start");
			   socket = serversocket.accept();
			   System.out.println("[" + socket.getInetAddress() + "]" + "����");
			   
			   //������ read / write
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
			 //socket ��ü�κ��� (��°�ü)
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






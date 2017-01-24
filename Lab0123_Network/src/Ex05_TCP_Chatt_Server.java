import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//���� : Ŭ���̾�Ʈ (1:1 ���)
//���� : read / write
//Ŭ���̾�Ʈ : read / write
//Ex03 ~ Ex04 > �������� ó��
//���ÿ� read , write
//read ����, write ���� > Thread ���

public class Ex05_TCP_Chatt_Server {

	public static void main(String[] args) {
		ServerSocket serversocket = null;
		try{
			serversocket = new ServerSocket(9999);
			System.out.println("���� �����...");
			Socket socket = serversocket.accept();
			
			//����
			//inputStream , outputStream ���� Socket �̶�� ��ü
			
			//ServerSend , ServerReveive Ŭ���� (Socket �༮�� �ּӰ� ����)
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
//��� : ServerSend , ServerReveive > socket �ڿ�(�ּ�)
//write
class ServerSend extends Thread{
	Socket socket;
	public ServerSend(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run(){
		try{
			//socket ���� ���;��� outputstream ó��
			//Console���� �Է��� ���� �޾Ƽ� ��½�Ʈ���� ���ؼ� Client ����
			
			//Scanner ���
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			//���ó�� (PrintWriter ���� ���� ����)
			PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
			//OutputStream out = socket.getOutputStream();
			//DataOutputStream dos = new DataOutputStream(out);
			
			while(true){
				String data = br.readLine(); //s.nextLine()
				if(data.equals("exit")) break;
				pw.println(data); // dos.writeUTF("")
			}
			System.out.println("Server Send �۾�����");
			
		}catch(Exception e){
			
		}
		
		
	}
}

//read 
//�Ʒ� �ڵ� �ϼ��ϼ��� (10��)

class ServerReceive extends Thread{
	Socket socket;
	public ServerReceive(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run(){
		BufferedReader br = null; //Line ���� ������ ó��
		try{
			//InputStreamReader ��� ���(Stream -> Reader)
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String data = null;
			while((data = br.readLine()) != null){
				System.out.println("Client ���� ���� �޽��� : [" + data + "]");
			}
			System.out.println("Server Receive �۾�����");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
}










import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

// ������ �ʼ� ��� : �ڱ��� IP, ��Ʈ��ȣ
// ServerSocket ���� > Ŭ���̾�Ʈ�� ��û ���

public class Ex03_TCP_Server {
	public static void main(String[] args) throws Exception {
		 ServerSocket serverSocket = new ServerSocket(7777);
		 String str = "���� �����Ϳ� ������ ���";
		 System.out.println("�������� : " + serverSocket.getInetAddress());
		 System.out.println("���� ���� ����� ...");
		 
		 Socket socket = serverSocket.accept(); // ���� ��� > ���� socket ����
		 System.out.println("����");
		 //////////////////////////////////////////////
		 // server => client
		 // ��Socket�� ���������� Stream�� �����ϰ� �ִ�.
		 OutputStream out = socket.getOutputStream();
		 DataOutputStream dos = new DataOutputStream(out);
		 dos.writeUTF("str"); // ������ Ŭ���̾�Ʈ�� write ������
		 //////////////////////////////////////////////
		 
		 System.out.println("���� ����");
		 
		 dos.close();
		 out.close();
		 socket.close();
		 serverSocket.close();
	}
}

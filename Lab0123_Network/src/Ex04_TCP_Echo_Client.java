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
		System.out.println("������ ����Ǿ����ϴ�.");
		Scanner scan = new Scanner(System.in);
		
		// ���� socket�� ����ؾ���. (read, write)
		// read �غ� : ���������� �ڵ� ���� �ٿ���.
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		
		// write �غ�
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		
		while(true) {
			System.out.println("Go!");
			System.out.print("���ڿ��� �Է����ּ��� : ");
			String servermsg = scan.next();
			// String servermsg = dis.readUTF(); // ���� ���� ������ �������� �ʴ´�.
			System.out.println("Server Msg : " + servermsg);
			
			// �޾Ƹ� ���
			dos.writeUTF(servermsg);
			
			if(servermsg.equals("exit")) break; // ���� ����
			
			dos.flush();
		}
		System.out.println("Ŭ���̾�Ʈ ����");
		dis.close();
		dos.close();
		socket.close();
	}

}

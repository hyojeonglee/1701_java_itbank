import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

// �ڵ� ������ ����ϴ�.

// ���� ����
// ����
// 1. ������ accept�ؼ� ������
// 2. Ŭ���̾�Ʈ�� ���� IP�� ������Ʈ�� �˰�, ���� ����
// 3. �� �ʿ� input, output ��� �����Ǿ���Ѵ�.
public class Ex04_TCP_Echo_Server {

	public static void main(String[] args) throws IOException, EOFException {
		ServerSocket serverSocket = new ServerSocket(9999);
		System.out.println("Ŭ���̾�Ʈ ���� ��� ��");
		Socket socket = serverSocket.accept();
		
		// Ŭ���̾�Ʈ socket�� ����ؾ���. (read, write)
		// read �غ�
		InputStream in = socket.getInputStream();
		DataInputStream dis = new DataInputStream(in);
		
		// write �غ�
		OutputStream out = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(out);
		
		while(true) {
			System.out.println("Go!");
			String clientmsg = dis.readUTF(); // ���� ���� ������ �������� �ʴ´�.
			System.out.println("Client Msg : " + clientmsg);
		
			// ���� ������ Client���� write���ش�.
			if(clientmsg.equals("exit")) break; // ���� ����
			
			// �޾Ƹ� ���
			dos.writeUTF(clientmsg);
			dos.flush();
		}
		System.out.println("Ŭ���̾�Ʈ exit ���� : ���� ����");
		dis.close();
		dos.close();
		in.close();
	}

}

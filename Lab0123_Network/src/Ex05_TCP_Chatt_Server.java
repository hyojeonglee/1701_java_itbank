import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//<�ڵ� ����ȭ�ÿ� ����� ��>
//1. �� ��, �а��� ��ü�� �����̴�! send�� receive Ŭ������ �����ڿ��� ����Ѵ�.
// �׷��� �ٸ� Ŭ���� ���� �־ �� �� ����.
// > �ذ� : ���� or ����

// ����-Ŭ���̾�Ʈ 1��1 ���
// ���� : read, write
// Ŭ���̾�Ʈ : read, write
// ����ó�� ����ó���� �ƴϰ� read�� write�� ���ÿ� ����Ǿ���Ѵ� > Thread!!!

public class Ex05_TCP_Chatt_Server {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(9999);
			System.out.println("���� ��� ��...");
			socket = serverSocket.accept();
			
			// ���� �ڵ� : inputStream, outputStream���� Socket�̶�� ��ü�� ����
			// socket.get..., socket.get~
			
			// �� �۾��� send�� receive class�� �����Ѵ�.
			// �׷����� Socket�� �ּҰ��� �����ؾ��Ѵ�.
		
			// Thread 2���� ���ư���.
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
	
	// �� ������ �ڵ带 ���ְ� ������??? Inner Class�� �ٲپ��ش�.
	
	@Override
	public void run() {
		try { 
			// socket���κ��� ���� OutputStream ó��
			// console���� �Է��� ���� �޾Ƽ� ��� ��Ʈ���� ���� Client���� ����
			
			// �Է�ó�� : ��ĳ�� ��� br���! (��� ��ĳ�� ���ΰ� ������ ������)
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			// ���ó�� : ������Ʈ�� PrintWriter ���! ��� ������ ���ϴ°� ���ϴ�.
			// �ٸ���� : 
			// OutputStream out = socket.getOutputStream();
			// DataOutputStream dos = new DataOutputStream(out);
			// �̰��� 8���� Ÿ������ output ����!
			PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
			
			while(true) {
				String data = br.readLine(); // s.nextLine();
				if(data.equals("exit")) break;
				pw.println(data); // == dos.writeUTF("");
			}
			System.out.println("Server Send �۾� ����!");
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
		BufferedReader br = null; // Line���� ������ ó��!
		try {
			// br = new BufferedReader(socket.getInputStream()); �Ұ���!
			// �ܿ��� ������ ��!
			// InputStreamReader ��� ���(Stream => Reader ��ȯ)
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String data = null;
			while((data = br.readLine()) != null) {
				System.out.println("Client�κ��� ���� �޽��� : [" + data + "]");
				// ���߿� awt�� swing���� �ٲپ�����! �ֿܼ����� ������
			}
			// System.out.println("Server Receiver �۾� ����");
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
//				if(clientmsg.equals("exit")) break; // ���� ����
//			}
//			System.out.println("Server Receive �۾� ����!");
//		} catch(Exception e) {
//			
//		}
	}
}
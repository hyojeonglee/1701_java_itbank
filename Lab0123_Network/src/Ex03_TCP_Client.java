import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Ex03_TCP_Client {

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		Socket socket = new Socket("192.168.101.1", 7777);
		System.out.println("������ ����Ǿ����ϴ�.");
		
		// �����κ��� ���� �޽���!
		InputStream in = socket.getInputStream();
		DataInputStream dis = new DataInputStream(in);
		
		String servermsg = dis.readUTF();
		System.out.println("�����κ��� ���� �޽��� : " + servermsg);
		dis.close();
		in.close();
		socket.close();
	}

}

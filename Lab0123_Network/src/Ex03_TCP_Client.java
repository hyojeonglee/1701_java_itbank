import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Ex03_TCP_Client {

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		Socket socket = new Socket("192.168.101.1", 7777);
		System.out.println("������ ����Ǿ����ϴ�.");
	}

}

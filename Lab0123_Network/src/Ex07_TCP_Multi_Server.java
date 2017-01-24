import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

//���� : 1:1 ä��
//���� API : (TCP)ServerSocket , Socket , I/O (DataInput, DataOut , Buffer..)
//           : Thread (���ÿ� read / write)
//           : ���� (socket ����) : Collection 
//           : TEST (UI : awt , swing > event ��� (�͸�Ŭ���� , inner class)
//���� ���� ���� ä�� (node.js) > script ��� 

//����ä��
//���� (1��) > Ŭ���̾�Ʈ1 , Ŭ���̾�Ʈ2
//socket ���� ���
public class Ex07_TCP_Multi_Server {
	HashMap<String, DataOutputStream> ClientMap;
	ServerSocket serversocket = null;
	Socket socket = null;

	public Ex07_TCP_Multi_Server() {
		// �� Ŭ���̾�Ʈ (Socket ��°�ü�� ����)
		ClientMap = new HashMap<>();
	}

	// 1. �ʱ�ȭ �Լ�(���� ����)
	public void init() {
		try {
			serversocket = new ServerSocket(9999);
			System.out.println("[��������]");
			while (true) {
				socket = serversocket.accept();// ������ �Ǹ�(socket)
				System.out.println("[" + socket.getInetAddress() + "/" + socket.getPort() + "]");

				// �ڵ��۾� (Ŭ���Ʈ ���ӽø��� Thread)
				// ..
				Thread thread = new  MultiServer(socket);
				thread.start();
			}
		} catch (Exception e) {
			System.out.println("init() :" + e.getMessage());
		}
	}

	// ���ӵ� ��� Ŭ���̾�Ʈ(socket)���� �޽����� �����ϴ� ��� �Լ� ����
	// ClientMap<"ȫ�浿",������ socket ���� �� DataOutputStream ��ü>
	// ClientMap<"������",������ socket ���� �� DataOutputStream ��ü>
	// ClientMap<"������",������ socket ���� �� DataOutputStream ��ü>
	public void SendAllMsg(String msg) {
		Iterator<String> ClinetKeySet = ClientMap.keySet().iterator();
		while (ClinetKeySet.hasNext()) {
			try {
				DataOutputStream clientout = ClientMap.get(ClinetKeySet.next());
				// ������ ����ڿ��� (client) �޽��� ����
				clientout.writeUTF(msg);
			} catch (Exception e) {
				System.out.println("SendAll_msg : " + e.getMessage());
			}
		}
	}

	// ���ӵ� ���� ����Ʈ �����ϱ�
	public String showUserList(String name) {
		StringBuilder output = new StringBuilder("<�����ڸ��>\r\n");
		Iterator<String> users = ClientMap.keySet().iterator();
		while (users.hasNext()) {
			try {
				String key = users.next();// ȫ�浿 , ������
				if (key.equals(name)) {
					key += "(*)";
				}
				output.append(key + "\r\n");
			} catch (Exception e) {
				System.out.println("ShowUserList ���� : " + e.getMessage());
			}
		}
		output.append("<" + ClientMap.size() + ">" + "�� ������...\r\n");
		return output.toString();
	}

	// �ӼӸ� ��� �Լ�
	public void SendToMsg(String fromname, String toname, String toMsg) {
		try {
			// DataOutputStream out = ClientMap.get(toname);
			// out.writeUTF(str);
			ClientMap.get(toname).writeUTF("�ӼӸ� from(" + fromname + ")=>" + toMsg);
			ClientMap.get(fromname).writeUTF("�ӼӸ� to(" + toname + ")=>" + toMsg);
		} catch (Exception e) {
			System.out.println("SendToMsg : " + e.getMessage());
		}
	}

	// Thread ���� (���� client read , write)
	class MultiServer extends Thread {
		Socket socket = null;
		DataInputStream in;
		DataOutputStream out;

		public MultiServer(Socket socket) {
			this.socket = socket;
			try {
				in = new DataInputStream(this.socket.getInputStream());
				out = new DataOutputStream(this.socket.getOutputStream());
			} catch (Exception e) {
				System.out.println("Multi Server Thread : " + e.getMessage());
			}
		}

		@Override
		public void run() {
			// �⺻ Ŭ���̾�Ʈ : in.readUTF() , out.WriteUTF()
			String name = ""; // Ŭ���̾�Ʈ���� �̸��� �޾Ƽ� ����
			try {
				// ����� ������ ���ؼ� ������ client(socket)���� �޽��� ����
				out.writeUTF("�̸��� �Է��ϼ���");
				name = in.readUTF();
				out.writeUTF("���� ä�ù濡 ����");
				// ������ ������ ��� �����(socket)���� �Էµ� ������ ����
				// �Լ�
				SendAllMsg(name + "�� �����Ͽ����ϴ�");
				/////////////////////////////////////////////////////
				// key point (����� Map �� �ֱ�)
				ClientMap.put(name, out); // Map<�̸�,��°�ü>
				System.out.println("���� ����͸� : ���� �����ڴ� " + ClientMap.size() + "��");

				// �߰����(��ȭ���)
				while (in != null) 
				{
						String msg = in.readUTF();
						// ä��â��> /������ > Client Enter
						// ������ ȸ�� ��� ���
						if (msg.startsWith("/")) 
						{
							if (msg.trim().equals("/������"))
							{
								// ��� ����� (������ �Լ�)
								out.writeUTF(showUserList(name));
							}
						}else if(msg.startsWith("/�ӼӸ�"))
						{
							String[] msgArr = msg.split("", 3);
							if (msgArr == null || msg.length() < 3) {
							// ä��â >/�ӼӸ� ȫ�浿 �氡�氡
							out.writeUTF("HELP : �ӼӸ� ���� :\r\n /�ӼӸ� [�����̸�] [�����޽���]");
							}else{
									// [0]>/�ӼӸ� , [1]>�����̸� ,[2]>�����޽���
									String toName = msgArr[1];
									String toMsg = msgArr[2];
									if (ClientMap.containsKey(toName))
									{
										// �޽��� ������
										// Ư�� ���濡�Ը� ä�� ���� ����
										// ��� ������ �Լ�
										SendToMsg(name, toName, toMsg);
									}else
									{
										out.writeUTF("�Է��Ͻ� ����ڰ� �����ϴ�");
									}
								}
						}else{
								SendAllMsg("[" + name + "]" + msg);
						     }
				 }

			} catch (Exception e) {
				System.out.println("Thread run ���ܹ߻�" + e.getMessage());
			}
		}
	}

	public static void main(String[] args) {
		Ex07_TCP_Multi_Server chattServer = new Ex07_TCP_Multi_Server();
		chattServer.init();

	}

}

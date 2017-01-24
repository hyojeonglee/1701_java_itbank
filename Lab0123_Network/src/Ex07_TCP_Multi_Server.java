import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

//기존 : 1:1 채팅
//사용된 API : (TCP)ServerSocket , Socket , I/O (DataInput, DataOut , Buffer..)
//           : Thread (동시에 read / write)
//           : 관리 (socket 관리) : Collection 
//           : TEST (UI : awt , swing > event 기술 (익명클래스 , inner class)
//실제 현재 업무 채팅 (node.js) > script 기반 

//다중채팅
//서버 (1대) > 클라이언트1 , 클라이언트2
//socket 관리 방법
public class Ex07_TCP_Multi_Server {
	HashMap<String, DataOutputStream> ClientMap;
	ServerSocket serversocket = null;
	Socket socket = null;

	public Ex07_TCP_Multi_Server() {
		// 각 클라이언트 (Socket 출력객체를 관리)
		ClientMap = new HashMap<>();
	}

	// 1. 초기화 함수(서버 소켓)
	public void init() {
		try {
			serversocket = new ServerSocket(9999);
			System.out.println("[서버시작]");
			while (true) {
				socket = serversocket.accept();// 접속이 되면(socket)
				System.out.println("[" + socket.getInetAddress() + "/" + socket.getPort() + "]");

				// 코드작업 (클라언트 접속시마다 Thread)
				// ..
				Thread thread = new  MultiServer(socket);
				thread.start();
			}
		} catch (Exception e) {
			System.out.println("init() :" + e.getMessage());
		}
	}

	// 접속된 모든 클라이언트(socket)에게 메시지를 전달하는 기능 함수 구현
	// ClientMap<"홍길동",각각의 socket 에서 얻어낸 DataOutputStream 객체>
	// ClientMap<"김유신",각각의 socket 에서 얻어낸 DataOutputStream 객체>
	// ClientMap<"도깨비",각각의 socket 에서 얻어낸 DataOutputStream 객체>
	public void SendAllMsg(String msg) {
		Iterator<String> ClinetKeySet = ClientMap.keySet().iterator();
		while (ClinetKeySet.hasNext()) {
			try {
				DataOutputStream clientout = ClientMap.get(ClinetKeySet.next());
				// 각각의 사용자에게 (client) 메시지 전달
				clientout.writeUTF(msg);
			} catch (Exception e) {
				System.out.println("SendAll_msg : " + e.getMessage());
			}
		}
	}

	// 접속된 유지 리스트 관리하기
	public String showUserList(String name) {
		StringBuilder output = new StringBuilder("<접속자목록>\r\n");
		Iterator<String> users = ClientMap.keySet().iterator();
		while (users.hasNext()) {
			try {
				String key = users.next();// 홍길동 , 김유신
				if (key.equals(name)) {
					key += "(*)";
				}
				output.append(key + "\r\n");
			} catch (Exception e) {
				System.out.println("ShowUserList 예외 : " + e.getMessage());
			}
		}
		output.append("<" + ClientMap.size() + ">" + "명 접속중...\r\n");
		return output.toString();
	}

	// 귓속말 기능 함수
	public void SendToMsg(String fromname, String toname, String toMsg) {
		try {
			// DataOutputStream out = ClientMap.get(toname);
			// out.writeUTF(str);
			ClientMap.get(toname).writeUTF("귓속말 from(" + fromname + ")=>" + toMsg);
			ClientMap.get(fromname).writeUTF("귓속말 to(" + toname + ")=>" + toMsg);
		} catch (Exception e) {
			System.out.println("SendToMsg : " + e.getMessage());
		}
	}

	// Thread 구현 (접속 client read , write)
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
			// 기본 클라이언트 : in.readUTF() , out.WriteUTF()
			String name = ""; // 클라이언트부터 이름을 받아서 저장
			try {
				// 연결된 소켓을 통해서 접속한 client(socket)에게 메시지 전달
				out.writeUTF("이름을 입력하세요");
				name = in.readUTF();
				out.writeUTF("현재 채팅방에 입장");
				// 서버에 접속한 모든 사용자(socket)에게 입력된 내용을 전달
				// 함수
				SendAllMsg(name + "님 입장하였습니다");
				/////////////////////////////////////////////////////
				// key point (사용자 Map 에 넣기)
				ClientMap.put(name, out); // Map<이름,출력객체>
				System.out.println("서버 모니터링 : 현재 접속자는 " + ClientMap.size() + "명");

				// 추가기능(대화기능)
				while (in != null) 
				{
						String msg = in.readUTF();
						// 채팅창에> /접속자 > Client Enter
						// 접속한 회원 목록 출력
						if (msg.startsWith("/")) 
						{
							if (msg.trim().equals("/접속자"))
							{
								// 모든 사용자 (별도의 함수)
								out.writeUTF(showUserList(name));
							}
						}else if(msg.startsWith("/귓속말"))
						{
							String[] msgArr = msg.split("", 3);
							if (msgArr == null || msg.length() < 3) {
							// 채팅창 >/귓속말 홍길동 방가방가
							out.writeUTF("HELP : 귓속말 사용법 :\r\n /귓속말 [상대방이름] [보낼메시지]");
							}else{
									// [0]>/귓속말 , [1]>상대방이름 ,[2]>보낼메시지
									String toName = msgArr[1];
									String toMsg = msgArr[2];
									if (ClientMap.containsKey(toName))
									{
										// 메시지 보내기
										// 특정 상대방에게만 채팅 내용 전달
										// 기능 별도의 함수
										SendToMsg(name, toName, toMsg);
									}else
									{
										out.writeUTF("입력하신 사용자가 없습니다");
									}
								}
						}else{
								SendAllMsg("[" + name + "]" + msg);
						     }
				 }

			} catch (Exception e) {
				System.out.println("Thread run 예외발생" + e.getMessage());
			}
		}
	}

	public static void main(String[] args) {
		Ex07_TCP_Multi_Server chattServer = new Ex07_TCP_Multi_Server();
		chattServer.init();

	}

}

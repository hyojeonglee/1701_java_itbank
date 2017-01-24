import java.io.DataOutputStream;
import java.util.HashMap;

// ctrl shift f 자동정렬
public class Ex07_TCP_Multi_Server {
	HashMap ClientMap = new HashMap();
	
	public static void main(String[] args) {
		
	}
	
	// 귓속말 기능 함수
	public void SendToMsg(String fromName, String toName, String toMsg) {
		try {
//			DataOutputStream out = ClientMap.get(toName);
//			out.writeUTF(str);
//			
//			ClientMap.get(toName).writeUTF("귓속말 from (" + fromName + ")=>" + toMsg);
//			ClientMap.get(fromName).writeUTF("귓속말 to (" + toName + ")=>" + toMsg);
		} catch(Exception e) {
			System.out.println("SendToMsg : " + e.getMessage());
		}
	}
}

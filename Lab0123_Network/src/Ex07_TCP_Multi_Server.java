import java.io.DataOutputStream;
import java.util.HashMap;

// ctrl shift f �ڵ�����
public class Ex07_TCP_Multi_Server {
	HashMap ClientMap = new HashMap();
	
	public static void main(String[] args) {
		
	}
	
	// �ӼӸ� ��� �Լ�
	public void SendToMsg(String fromName, String toName, String toMsg) {
		try {
//			DataOutputStream out = ClientMap.get(toName);
//			out.writeUTF(str);
//			
//			ClientMap.get(toName).writeUTF("�ӼӸ� from (" + fromName + ")=>" + toMsg);
//			ClientMap.get(fromName).writeUTF("�ӼӸ� to (" + toName + ")=>" + toMsg);
		} catch(Exception e) {
			System.out.println("SendToMsg : " + e.getMessage());
		}
	}
}

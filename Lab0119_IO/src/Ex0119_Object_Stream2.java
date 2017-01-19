import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

// 복원
public class Ex0119_Object_Stream2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "UserData.ser";
		// 요렇게 밖으로 빼는 이유는, finally 블록에서 사용하려고
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream(fileName);
			bis = new BufferedInputStream(fis);
			// 역직렬화~
			ois = new ObjectInputStream(bis);
			// 읽을 때는 몇개 씩 읽으려나
			UserInfo r1 = (UserInfo) ois.readObject(); // 형변환 필요!
			UserInfo r2 = (UserInfo) ois.readObject();
			
			System.out.println("파일에서 읽은 객체 데이터 복원 > " + r1.toString());
			System.out.println("파일에서 읽은 객체 데이터 복원 > " + r2.toString());
		} catch(Exception e) {
			
		} finally {
			try {
				ois.close();
				bis.close();
				fis.close();
			} catch(Exception e) {
			}
		}
	}
}

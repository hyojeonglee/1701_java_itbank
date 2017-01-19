import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Ex0119_Object_Stream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "UserData.ser";
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			// ObjectInputStream ois = new ObjectInputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			
			UserInfo u1 = new UserInfo("superman", "super", 1000);
			UserInfo u2 = new UserInfo("scott", "tiger", 40);
			
			// 직렬화~
			// 파일에 객체를 쓸 것
			oos.writeObject(u1);
			oos.writeObject(u2); // 파일에 하나만 쓸수있지 않나
			
			oos.close();
			bos.close();
			fos.close();
			System.out.println("파일생성 - 직렬화 - 객체 write");
			
		} catch(Exception e) {
			
		}
	}

}

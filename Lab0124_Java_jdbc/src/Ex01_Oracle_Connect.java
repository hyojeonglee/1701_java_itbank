import java.sql.Connection;
import java.sql.DriverManager;

public class Ex01_Oracle_Connect {
	// �Ź� ���� ���� �̱��� �������� ���� �ȴ�.
	// ���� �ð���~
	
	public static void main(String[] args) throws Exception {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("����̹� �ε�");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
							"hyojeong",
							"1004");
			System.out.println(conn.isClosed()); // db�� ������? �ƴ�! false ���;� ��! ����~~
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // ��ü�� new���� �ʰ� ����̹��� ����ø�
	}

}

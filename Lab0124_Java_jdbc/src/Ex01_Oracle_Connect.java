import java.sql.Connection;
import java.sql.DriverManager;

public class Ex01_Oracle_Connect {
	// 매번 쓰지 말고 싱글톤 패턴으로 빼면 된다.
	// 다음 시간에~
	
	public static void main(String[] args) throws Exception {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("드라이버 로딩");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
							"hyojeong",
							"1004");
			System.out.println(conn.isClosed()); // db야 닫혔니? 아니! false 나와야 됨! 성공~~
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 객체를 new하지 않고 드라이버를 끌어올림
	}

}

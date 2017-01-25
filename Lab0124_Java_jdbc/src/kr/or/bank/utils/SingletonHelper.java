package kr.or.bank.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//
public class SingletonHelper {
   
	private static Connection conn =null;
	private SingletonHelper(){}
	
	public static Connection getConnection(String dsn) throws ClassNotFoundException , SQLException{
		if(conn != null){
			System.out.println("conn is not null");
			return conn;
		}
		if(dsn.equals("mysql")){
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db",
														  "hyojeong",
														  "1004");
		}else if(dsn.equals("oracle")){
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
														  "hyojeong",
														  "1004");
		}
		return conn;
	}
	
//	�̱��� �������� ������ ��ü conn �ϳ��� ����Ŭ�� mySQL ��� �����ϰ� ������?
//	conn�� �̹� ����Ŭ ��ü�� �����Ƿ� null�� �ٽ� �־��ָ� �ȴ�.
	
	public static void DbClose(){
		if(conn != null){
			try{
				conn.close();
				conn = null; // �ٽ�!
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
}







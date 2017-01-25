import java.sql.Connection;
import java.sql.SQLException;

import kr.or.bank.utils.ConnectionHelper;
import kr.or.bank.utils.SingletonHelper;

public class Ex03_Oracle_Helper {
	static Connection conn = null;
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		conn =ConnectionHelper.getConnetion("oracle");
		System.out.println(conn.toString());
		System.out.println(conn.isClosed());
		System.out.println(conn.getMetaData().getDatabaseProductName());
		System.out.println(conn.getMetaData().getDatabaseProductVersion());
		ConnectionHelper.close(conn);
		System.out.println(conn.toString());
		System.out.println(conn.isClosed());
		
		
		conn = ConnectionHelper.getConnecton("oracle", "hr", "1004");
		System.out.println(conn.toString());
		System.out.println(conn.isClosed());
		ConnectionHelper.close(conn);
		//////////////////////////////////////////////////////////////
		
		conn =ConnectionHelper.getConnetion("oracle");
		System.out.println(conn.toString());
		
		conn =ConnectionHelper.getConnetion("oracle");
		System.out.println(conn.toString());
		
		/////////////////////////////////////////////////////////////
		//singleton »ç¿ë
		conn = SingletonHelper.getConnection("oracle");
		System.out.println(conn.toString());
		SingletonHelper.DbClose();
		
		conn = SingletonHelper.getConnection("oracle");
		System.out.println(conn.toString());
		
		conn = SingletonHelper.getConnection("mysql");
		System.out.println(conn.toString());
	}

}

package kr.or.bank.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

//많이 사용되는 함수가 있다면 > 설계시 > static

public class ConnectionHelper {

	public static Connection getConnetion(String dsn){
		Connection conn = null;
		try{
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
		}catch (Exception e) {
			
		}finally {
			return conn;
		}		
		
	}
	
	public static Connection getConnecton(String dsn, String uid ,String pwd){
		Connection conn = null;
		try{
			if(dsn.equals("mysql")){
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db",
															  uid,
															  pwd);
			}else if(dsn.equals("oracle")){
				Class.forName("oracle.jdbc.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
															 uid,
															 pwd);
			}
		}catch (Exception e) {
			
		}finally {
			return conn;
		}		
	}

	//자원해제
	public static void close(Connection conn){
		if(conn != null){try{ conn.close();} catch(Exception e){}}
	}
	public static void close(Statement stmt){
		if(stmt != null){try{ stmt.close();} catch(Exception e){}}
	}
	public static void close(ResultSet rs){
		if(rs != null){try{ rs.close();} catch(Exception e){}}
	}
	public static void close(PreparedStatement pstmt){
		if(pstmt != null){try{ pstmt.close();} catch(Exception e){}}
	}
	
}

package UTILS;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	
//	싱글톤 패턴으로 생성한 객체 conn 하나로 오라클과 mySQL 모두 참조하고 싶으면?
//	conn에 이미 오라클 객체가 있으므로 null을 다시 넣어주면 된다.
	
	public static void DbClose(){
		if(conn != null){
			try{
				conn.close();
				conn = null; // 핵심!
			}catch(Exception e){
				e.printStackTrace();
			}
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







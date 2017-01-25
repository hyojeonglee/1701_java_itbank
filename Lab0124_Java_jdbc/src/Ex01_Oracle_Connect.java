import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
/*
  1. Java > 오라클 DB연동
  2. Java(App) > JDBC API(java.sql.*) 
  3. Java(App) > 특정 벤더 DB 연동 > 벤더사가 제공 드라이버 다운로드> 오라클 (ojdbc6.jar) > import
  4. ojdbc6.jar > 프로젝트 > 등록(참조)
  5. 드라이버 메모리 상주 ( new Person() : Class.forName('클래스 이름') 메모리 로딩
  6. 연결문자열 (오라클 서버에게 드라이버를 통해서 연결문자열 ...) 
  7. Java (CRUD) > Create(INSERT) , Read(SELECT : 70%) , Update(UPDATE) , Delete(DELETE)
  8. 드라이버 로딩 > 연결 (객체 생성) > 명령 (객체 생성) > 명령실행 > 결과 처리(화면출력) > 자원해제
                     Connection         Command           Command(함수)    ResultSet 
*/
public class Ex01_Oracle_Connect {
	// 매번 쓰지 말고 싱글톤 패턴으로 빼면 된다.
	// 객체를 new하지 않고 드라이버를 끌어올림
	
	public static void main(String[] args) throws Exception {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("드라이버 로딩");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
							"hyojeong",
							"1004");
			System.out.println("연결 여부 : " + conn.isClosed()); // db야 닫혔니? 아니! false 나와야 됨! 성공~~
			stmt = conn.createStatement(); //명령객체 생성
			String sql="select empno, ename from emp";
			
			rs = stmt.executeQuery(sql); //명령 실행
			
			//화면 출력
			while(rs.next()){ //row 데이터 존재하면
				//System.out.println(rs.getInt("empno") + "-" + rs.getString("ename"));
				System.out.println(rs.getInt(1) + "-" + rs.getString(2)); //결과 컬럼번호 1 부터
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//자원해제
			if(rs != null){try{ rs.close();} catch(Exception e){}}
			if(stmt != null){try{ stmt.close();} catch(Exception e){}}
			if(conn != null){try{ conn.close();} catch(Exception e){}}
			
			System.out.println(conn.isClosed());
		}
	}

}

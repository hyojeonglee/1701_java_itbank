import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Ex02_Oracle_Connect {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
														  "superman",
														  "1004");
			//명령 객체 생성
			stmt = conn.createStatement();
			String job="";
			Scanner sc = new Scanner(System.in);
			System.out.print("직종 입력:");
			job = sc.nextLine();
			//select * from emp where ename='SCOTT'
			//이런 구시대적인 코드
			String sql="select empno, ename, job from emp where job='" + job + "'";
			
			rs = stmt.executeQuery(sql);
			
			/*
			if(rs.next()){  //데이터 1건 (row)
				System.out.println(rs.getInt("empno"));
			}else{ //데이터 없는 경우  처리
				System.out.println("조회된 데이터가 없습니다");
			}
			
			or
			
			while(rs.next()){} //데이터 여러건 처리 //단점 : 데이터 없는 경우 처리 안되요
			
			*/
			//데이터 1건 or 데이터 여러건 or 없는 경우
			if(rs.next()){
				do{
					System.out.println(rs.getInt(1) +"/"+ rs.getString(2)+"/" + rs.getString(3));
					
				}while(rs.next());
			}else{
				System.out.println("데이터 없어요");
			}
			
		}catch(Exception e){
			
		}finally {
			if(rs != null){try{ rs.close();} catch(Exception e){}}
			if(stmt != null){try{ stmt.close();} catch(Exception e){}}
			if(conn != null){try{ conn.close();} catch(Exception e){}}
		}

	}

}

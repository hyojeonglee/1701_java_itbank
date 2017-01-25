import java.sql.Connection;
import java.sql.PreparedStatement;

import kr.or.bank.utils.ConnectionHelper;
import kr.or.bank.utils.SingletonHelper;

// DML : 데이터 조작어 insert, update, delete
public class Ex05_Oracle_DML {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// insert, update, delete는 select가 아니니까 결과 집합이 반환되진 않는다.
		// > Result set객체는 안만들어도 된다.
		// 대신 다른 값들을 리턴해준다.
		
		// conn.setAutoCommit(autoCommit); > 얘를 false로 해두면, 내가 직접 롤백 및 커밋을 제어할 수 있다.
		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "insert into emp(empno, ename, deptno) values(?, ?, ?)";
			pstmt = conn.prepareStatement(sql); // 컴파일된 쿼리를 얻는다~
			// 값을 지정해준다.
			pstmt.setInt(1, 9999);
			pstmt.setString(2, "Jeong");
			pstmt.setInt(3, 10);
			
			int numberOfRow = pstmt.executeUpdate(); // insert, update, delete 모두 executeUpdate()사용!
			// 이것의 리턴타입은 int, 반영된 행의 갯수 리턴!
			if(numberOfRow > 0) // 성공한 경우~
				System.out.println("Insert row Count : " + numberOfRow);
			else
				System.out.println("Insert Fail : " + numberOfRow);
		} catch(Exception e) {
			
		} finally {
			ConnectionHelper.close(pstmt);
			// conn은 어차피 계속 사용할 것이니까 close하지 말기!
		}
	}

}

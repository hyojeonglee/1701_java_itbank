import java.sql.Connection;
// 왜 Connection을 인터페이스로 만들었을까?
// mySQL, Oracle 모두 Connection 쓰기 때문이다.
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.or.bank.utils.ConnectionHelper;
import kr.or.bank.utils.SingletonHelper;

public class Ex04_Oracle_Preparestatement {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null; // 해커 공격 막음!
		ResultSet rs = null;
		try {
			conn = SingletonHelper.getConnection("oracle"); // 소문자야!
			
//			conn = conn.createStatement();
//			String sql = "s...";
//			stmt.exe(sql); 실행과 동시에 쿼리를 올린다.
			
			String sql = "select empno , ename from emp where deptno=?";
//			select empno , ename from emp where deptno=10
//			select empno , ename from emp where deptno=20
			// 위 두 쿼리를 오라클은 다른 쿼리로 인지한다... 값만 바꾼건데? > 성능이 떨어짐!
			// preparedStatement 쓰면 비효율적인 작업을 없애준다.
			pstmt = conn.prepareStatement(sql);
			// exec전에 쿼리를 오라클에게 보내주면
			// 오라클은 공유풀에 쿼리를 올려둔다. (컴파일 해둔다.)
			// 이제 파라미터로 인자를 전달받아 이미 컴파일된 쿼리를 실행한다.
			// 따라서, ?에 해당하는 파라미터만 설정해주면 된다.
			pstmt.setInt(1, 30); // setInt ?의 타입을 지정하고 1은 첫번째 물음표라는 뜻이다.
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do { // do while로 일단 한 건일 때 처리! 
					System.out.println(rs.getInt(1) + "/" + rs.getString(2));
				} while(rs.next()); // 두 건 이상인경우
			} else {
				System.out.println("데이터가 없습니다.");
			}
			// jdbc는 인덱스가 모두 1부터 시작한다.
		} catch(Exception e) {
			
		} finally {
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
		}
	}

}

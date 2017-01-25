import java.sql.Connection;
import java.sql.PreparedStatement;

import kr.or.bank.utils.ConnectionHelper;
import kr.or.bank.utils.SingletonHelper;

// DML : ������ ���۾� insert, update, delete
public class Ex05_Oracle_DML {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// insert, update, delete�� select�� �ƴϴϱ� ��� ������ ��ȯ���� �ʴ´�.
		// > Result set��ü�� �ȸ��� �ȴ�.
		// ��� �ٸ� ������ �������ش�.
		
		// conn.setAutoCommit(autoCommit); > �긦 false�� �صθ�, ���� ���� �ѹ� �� Ŀ���� ������ �� �ִ�.
		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "insert into emp(empno, ename, deptno) values(?, ?, ?)";
			pstmt = conn.prepareStatement(sql); // �����ϵ� ������ ��´�~
			// ���� �������ش�.
			pstmt.setInt(1, 9999);
			pstmt.setString(2, "Jeong");
			pstmt.setInt(3, 10);
			
			int numberOfRow = pstmt.executeUpdate(); // insert, update, delete ��� executeUpdate()���!
			// �̰��� ����Ÿ���� int, �ݿ��� ���� ���� ����!
			if(numberOfRow > 0) // ������ ���~
				System.out.println("Insert row Count : " + numberOfRow);
			else
				System.out.println("Insert Fail : " + numberOfRow);
		} catch(Exception e) {
			
		} finally {
			ConnectionHelper.close(pstmt);
			// conn�� ������ ��� ����� ���̴ϱ� close���� ����!
		}
	}

}

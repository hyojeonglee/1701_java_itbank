import java.sql.Connection;
// �� Connection�� �������̽��� ���������?
// mySQL, Oracle ��� Connection ���� �����̴�.
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.or.bank.utils.ConnectionHelper;
import kr.or.bank.utils.SingletonHelper;

public class Ex04_Oracle_Preparestatement {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null; // ��Ŀ ���� ����!
		ResultSet rs = null;
		try {
			conn = SingletonHelper.getConnection("oracle"); // �ҹ��ھ�!
			
//			conn = conn.createStatement();
//			String sql = "s...";
//			stmt.exe(sql); ����� ���ÿ� ������ �ø���.
			
			String sql = "select empno , ename from emp where deptno=?";
//			select empno , ename from emp where deptno=10
//			select empno , ename from emp where deptno=20
			// �� �� ������ ����Ŭ�� �ٸ� ������ �����Ѵ�... ���� �ٲ۰ǵ�? > ������ ������!
			// preparedStatement ���� ��ȿ������ �۾��� �����ش�.
			pstmt = conn.prepareStatement(sql);
			// exec���� ������ ����Ŭ���� �����ָ�
			// ����Ŭ�� ����Ǯ�� ������ �÷��д�. (������ �صд�.)
			// ���� �Ķ���ͷ� ���ڸ� ���޹޾� �̹� �����ϵ� ������ �����Ѵ�.
			// ����, ?�� �ش��ϴ� �Ķ���͸� �������ָ� �ȴ�.
			pstmt.setInt(1, 30); // setInt ?�� Ÿ���� �����ϰ� 1�� ù��° ����ǥ��� ���̴�.
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do { // do while�� �ϴ� �� ���� �� ó��! 
					System.out.println(rs.getInt(1) + "/" + rs.getString(2));
				} while(rs.next()); // �� �� �̻��ΰ��
			} else {
				System.out.println("�����Ͱ� �����ϴ�.");
			}
			// jdbc�� �ε����� ��� 1���� �����Ѵ�.
		} catch(Exception e) {
			
		} finally {
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
		}
	}

}

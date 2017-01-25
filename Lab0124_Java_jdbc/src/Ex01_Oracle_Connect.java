import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
/*
  1. Java > ����Ŭ DB����
  2. Java(App) > JDBC API(java.sql.*) 
  3. Java(App) > Ư�� ���� DB ���� > �����簡 ���� ����̹� �ٿ�ε�> ����Ŭ (ojdbc6.jar) > import
  4. ojdbc6.jar > ������Ʈ > ���(����)
  5. ����̹� �޸� ���� ( new Person() : Class.forName('Ŭ���� �̸�') �޸� �ε�
  6. ���Ṯ�ڿ� (����Ŭ �������� ����̹��� ���ؼ� ���Ṯ�ڿ� ...) 
  7. Java (CRUD) > Create(INSERT) , Read(SELECT : 70%) , Update(UPDATE) , Delete(DELETE)
  8. ����̹� �ε� > ���� (��ü ����) > ��� (��ü ����) > ��ɽ��� > ��� ó��(ȭ�����) > �ڿ�����
                     Connection         Command           Command(�Լ�)    ResultSet 
*/
public class Ex01_Oracle_Connect {
	// �Ź� ���� ���� �̱��� �������� ���� �ȴ�.
	// ��ü�� new���� �ʰ� ����̹��� ����ø�
	
	public static void main(String[] args) throws Exception {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("����̹� �ε�");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
							"hyojeong",
							"1004");
			System.out.println("���� ���� : " + conn.isClosed()); // db�� ������? �ƴ�! false ���;� ��! ����~~
			stmt = conn.createStatement(); //��ɰ�ü ����
			String sql="select empno, ename from emp";
			
			rs = stmt.executeQuery(sql); //��� ����
			
			//ȭ�� ���
			while(rs.next()){ //row ������ �����ϸ�
				//System.out.println(rs.getInt("empno") + "-" + rs.getString("ename"));
				System.out.println(rs.getInt(1) + "-" + rs.getString(2)); //��� �÷���ȣ 1 ����
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//�ڿ�����
			if(rs != null){try{ rs.close();} catch(Exception e){}}
			if(stmt != null){try{ stmt.close();} catch(Exception e){}}
			if(conn != null){try{ conn.close();} catch(Exception e){}}
			
			System.out.println(conn.isClosed());
		}
	}

}

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
			//��� ��ü ����
			stmt = conn.createStatement();
			String job="";
			Scanner sc = new Scanner(System.in);
			System.out.print("���� �Է�:");
			job = sc.nextLine();
			//select * from emp where ename='SCOTT'
			//�̷� ���ô����� �ڵ�
			String sql="select empno, ename, job from emp where job='" + job + "'";
			
			rs = stmt.executeQuery(sql);
			
			/*
			if(rs.next()){  //������ 1�� (row)
				System.out.println(rs.getInt("empno"));
			}else{ //������ ���� ���  ó��
				System.out.println("��ȸ�� �����Ͱ� �����ϴ�");
			}
			
			or
			
			while(rs.next()){} //������ ������ ó�� //���� : ������ ���� ��� ó�� �ȵǿ�
			
			*/
			//������ 1�� or ������ ������ or ���� ���
			if(rs.next()){
				do{
					System.out.println(rs.getInt(1) +"/"+ rs.getString(2)+"/" + rs.getString(3));
					
				}while(rs.next());
			}else{
				System.out.println("������ �����");
			}
			
		}catch(Exception e){
			
		}finally {
			if(rs != null){try{ rs.close();} catch(Exception e){}}
			if(stmt != null){try{ stmt.close();} catch(Exception e){}}
			if(conn != null){try{ conn.close();} catch(Exception e){}}
		}

	}

}

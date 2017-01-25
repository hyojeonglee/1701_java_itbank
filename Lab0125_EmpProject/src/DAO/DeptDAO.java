package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import DTO.Dept;
import UTILS.SingletonHelper;

// Goal : �� ȥ�� db �۾�(CRUD)
// �Լ�(select, insert, update, delete)
// Q. �� ���̺� ������� �Լ��� �ּ� �� �� �����? �ּ� �ټ���!
// A. insert, update, delete 3���� Ȯ��!
//    select�� �� �� ��������! 1. ��ü select 2. ���� select(PK ������� ���� ������ �Լ�)

public class DeptDAO {
	
	// 1. select deptno, dname, loc from dept where deptno=?
	public Dept getDeptListByDeptno(int deptno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Dept singleDept = null;
		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "select deptno, dname, loc from dept where deptno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			
			rs = pstmt.executeQuery();
			while(rs.next()) { 
				singleDept = new Dept();
				singleDept.setDeptno(rs.getInt("deptno"));
				singleDept.setDname(rs.getString("dname"));
				singleDept.setLoc(rs.getString("loc"));
			}
		} catch(Exception e) {
			
		} finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
		}
		return singleDept;
	}
	
	// 2. select deptno, dname, loc from dept
	//    Dept ��ü �ϳ��� row �ϳ��̴�! > �� �� ����� ��� �� �� �����Ƿ� �����迭 ����.
	public ArrayList<Dept> GetDeptAllList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Dept> deptList = new ArrayList<>();
		
		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "select deptno, dname, loc from dept";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) { 
				Dept singleDept = new Dept(); // while ���ο��� ����ؼ� ���� ����������!
				singleDept.setDeptno(rs.getInt(1));
				singleDept.setDname(rs.getString(2));
				singleDept.setLoc(rs.getString(3));
				deptList.add(singleDept);
			}
		} catch(Exception e) {
			
		} finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
		}
		return deptList;
	}
	
	// 3. insert
	// insert into dept(deptno, dname, loc) values(?,?,?)
	// �̶� public int InsertDept(int deptno, String dname, String loc) ���ٴ�
	public int insertDept(Dept dept) { // �̰� �� ����.
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "insert into dept(deptno, dname, loc) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, dept.getDeptno());
			pstmt.setString(2, dept.getDname());
			pstmt.setString(3, dept.getLoc());
			
			rowCount = pstmt.executeUpdate();
		} catch(Exception e) {
			
		} finally {
			SingletonHelper.close(pstmt);
		}
		return rowCount;
	}
	
	// 4. Update
	// update dept set dname = ?, loc = ? where deptno=?
	public int updateDept(Dept dept) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		Scanner s = new Scanner(System.in);
		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "update dept set dname = ?, loc = ? where deptno=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dept.getDname());
			pstmt.setString(2, dept.getLoc());
			pstmt.setInt(3, dept.getDeptno());
			
			rowCount = pstmt.executeUpdate();
		} catch(Exception e) {
			
		} finally {
			SingletonHelper.close(pstmt);
		}
		return rowCount;
	}
	
	// 5. Delete
	// delete from dept where deptno=?
	public int deleteDept(int deptno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		Scanner s = new Scanner(System.in);
		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "delete from dept where deptno=?";
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setInt(1, deptno);
			
			rowCount = pstmt.executeUpdate();
		} catch(Exception e) {
			
		} finally {
			SingletonHelper.close(pstmt);
		}
		return rowCount;
	}
}

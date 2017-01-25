package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import DTO.Dept;
import UTILS.SingletonHelper;

// Goal : 얘 혼자 db 작업(CRUD)
// 함수(select, insert, update, delete)
// Q. 한 테이블 대상으로 함수를 최소 몇 개 만들까? 최소 다섯개!
// A. insert, update, delete 3개는 확정!
//    select는 두 개 만들어야함! 1. 전체 select 2. 조건 select(PK 기반으로 쿼리 던지는 함수)

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
	//    Dept 객체 하나가 row 하나이다! > 이 때 몇개인지 사실 알 수 없으므로 동적배열 쓴다.
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
				Dept singleDept = new Dept(); // while 내부에서 계속해서 새로 만들어줘야함!
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
	// 이때 public int InsertDept(int deptno, String dname, String loc) 보다는
	public int insertDept(Dept dept) { // 이게 더 낫다.
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

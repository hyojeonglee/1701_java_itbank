import java.util.ArrayList;

import DAO.DeptDAO;
import DTO.Dept;

public class Program {

	public static void main(String[] args) {
		DeptDAO dao = new DeptDAO();
		Dept dept = dao.getDeptListByDeptno(20);
		if(dept != null) {
			System.out.println("[Single Row Data]");
			printDept(dept);
		}
		else {
			System.out.println("Single Row Data Fail!");
		}
		
		System.out.println("*******************************************");
		
		ArrayList<Dept> deptList = dao.GetDeptAllList();
		if(deptList != null) {
			System.out.println("[Multi Row Data]");
			printDept(deptList);
		}
		else
			System.out.println("Multi Row Data Fail!");
		
		System.out.println("*******************************************");
		
		// 상상해보면
		// Web() > Server > request.getParameter("deptno") > 객체
		System.out.println("[INSERT DEPT ROW]");
		Dept insertDept = new Dept();
		insertDept.setDeptno(60);
		insertDept.setDname("IT");
		insertDept.setLoc("Seoul");
		int row = dao.insertDept(insertDept);
		if(row > 0) {
			System.out.println("Insert Row Data : " + row + "건");
		}
		else { 
			System.out.println("Insert Data Fail!");
		}
		// 방금 전 입력한 데이터 보고싶음
		deptList = dao.GetDeptAllList();
		printDept(deptList);
		
		System.out.println("*******************************************");
		System.out.println("[UPDATE DEPT ROW]");
		Dept updateDept = insertDept;
		updateDept.setDeptno(60);
		updateDept.setLoc("Busan");
		row = dao.updateDept(updateDept);
		if(row > 0) {
			System.out.println("Update Row Data : " + row + "건");
		}
		else { 
			System.out.println("Update Data Fail!");
		}
		deptList = dao.GetDeptAllList();
		printDept(deptList);
		
		System.out.println("*******************************************");
		System.out.println("[DELETE DEPT ROW]");
		row = dao.deleteDept(60);
		if(row > 0) {
			System.out.println("Delete Row Data : " + row + "건");
		}
		else { 
			System.out.println("Delete Data Fail!");
		}
		deptList = dao.GetDeptAllList();
		printDept(deptList);
	}
	
	public static void printDept(Dept dept) {
		System.out.println(dept.toString());
	}
	
	public static void printDept(ArrayList<Dept> deptList) {
		for(Dept dept : deptList)
			System.out.println(dept.toString());
	}
}

import java.util.ArrayList;

class EmpData {
	private ArrayList list;
	private int[] number;
	
	public EmpData() {
		this.list = new ArrayList();
		this.number = new int[10];
	}
	
	public ArrayList getList() {
		return this.list;
	}
	
	public void setList(ArrayList list) {
		this.list = list;
	}

	public int[] getNumber() {
		return number;
	}

	public void setNumber(int[] number) {
		this.number = number;
	}
}

public class Ex0117_ArrayList2 {
	public static void main(String[] args) {
		EmpData empdata = new EmpData();
		ArrayList list = new ArrayList();
		list.add(100);
		list.add(200);
		empdata.setList(list);
		System.out.println(empdata.getList().toString());
	}
}

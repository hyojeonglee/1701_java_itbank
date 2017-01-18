import java.util.ArrayList;

// Generic �� �� ������ ���� �̿��ϴ� ���� ����!

class Product {
	
}

class Tv extends Product {
	@Override
	public String toString() {
		return "Tv";
	}
}

class Audio extends Product {
	
}

class Notebook {
	
}

public class Ex0118_Generic2 {
	public static void main(String[] args) {
		Product[] product = {new Tv(), new Audio()};
		
		ArrayList<Product> pList = new ArrayList<>(); 
		// ���� pList���� �����, Ƽ�� ��� �� �� �ִ�.
		// ��Ʈ���� �ȵ�! ��Ӿ�������!
		pList.add(new Tv());
		pList.add(new Audio());
		// pList.add(new Notebook()); ����!
		for(Product p : pList) {
			System.out.println(p.toString());
			// ����� Tv�� toString override �����ϱ� Tv�� ������, ������� ����Ʈ�� ���´�.
		}
	}
}

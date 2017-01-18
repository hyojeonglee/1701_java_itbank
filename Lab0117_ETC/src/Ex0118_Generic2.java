import java.util.ArrayList;

// Generic 쓸 때 다형성 개념 이용하는 것이 좋다!

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
		// 이제 pList에는 오디오, 티비가 모두 들어갈 수 있다.
		// 노트북은 안됨! 상속안했으니!
		pList.add(new Tv());
		pList.add(new Audio());
		// pList.add(new Notebook()); 에러!
		for(Product p : pList) {
			System.out.println(p.toString());
			// 결과는 Tv는 toString override 했으니까 Tv로 나오고, 오디오는 디폴트로 나온다.
		}
	}
}

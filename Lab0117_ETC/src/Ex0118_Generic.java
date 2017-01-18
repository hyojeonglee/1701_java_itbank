
import java.util.ArrayList;

// ���ʸ�(Generic)
// jdk1.5����!
// C#, java�� �ʼ������� ���


// 1. ��� �� Ÿ���� �������� Ȯ���Ѵ�.(Ÿ�� ����) > Object Ÿ�� Ż��!

class Person {
	int age = 100;
}
// ��� 1
class MyGen<T> { // T�� type parameter!
	T obj;
	
	void add(T obj) {
		this.obj = obj;
	}
}
// ��� 2
class Car {
	String carName;
	
	Car(String carName) {
		this.carName = carName;
	}
	
	String getCarName() {
		return this.carName;
	}
}

public class Ex0118_Generic {
	public static void main(String[] args) {
		MyGen<String> mygen = new MyGen<>(); // ��~
		mygen.add("���ڿ�");
		System.out.println(mygen.obj);
		
		MyGen<Car> mygen2 = new MyGen<>();
		mygen2.add(new Car("���"));
		System.out.println(mygen2.obj.getCarName()); // �̷��� ����ϴ±���!
		
		//--------------Generic in ArrayList(Collection)--------------//
		
		ArrayList<String> list = new ArrayList<>();
		
		// ������ �޴� List > Wrapper Ŭ���� ����Ѵ�.
		ArrayList<Integer> intList = new ArrayList<>();
		intList.add(1);
		
		// ���� : Car type �� �� ������ for���� ���Ⱑ ��������!!!
		ArrayList<Car> carlist = new ArrayList<>();
		carlist.add(new Car("���"));
		carlist.add(new Car("����"));
		carlist.add(new Car("Ʈ��"));
		
		for(Car car : carlist)
			System.out.println(car.getCarName());
		
		
	}
}

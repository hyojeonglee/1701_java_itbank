
import java.util.ArrayList;

// 제너릭(Generic)
// jdk1.5부터!
// C#, java는 필수적으로 사용


// 1. 사용 시 타입의 안정성을 확보한다.(타입 강제) > Object 타입 탈피!

class Person {
	int age = 100;
}
// 방법 1
class MyGen<T> { // T는 type parameter!
	T obj;
	
	void add(T obj) {
		this.obj = obj;
	}
}
// 방법 2
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
		MyGen<String> mygen = new MyGen<>(); // 오~
		mygen.add("문자열");
		System.out.println(mygen.obj);
		
		MyGen<Car> mygen2 = new MyGen<>();
		mygen2.add(new Car("페라리"));
		System.out.println(mygen2.obj.getCarName()); // 이렇게 써야하는구나!
		
		//--------------Generic in ArrayList(Collection)--------------//
		
		ArrayList<String> list = new ArrayList<>();
		
		// 정수만 받는 List > Wrapper 클래스 써야한다.
		ArrayList<Integer> intList = new ArrayList<>();
		intList.add(1);
		
		// 장점 : Car type 일 때 개선된 for문을 쓰기가 용이해짐!!!
		ArrayList<Car> carlist = new ArrayList<>();
		carlist.add(new Car("모닝"));
		carlist.add(new Car("포니"));
		carlist.add(new Car("트럭"));
		
		for(Car car : carlist)
			System.out.println(car.getCarName());
		
		
	}
}

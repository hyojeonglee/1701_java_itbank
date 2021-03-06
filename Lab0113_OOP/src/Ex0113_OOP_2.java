class Human {
	int age;
	String name;
}

class Test {
	Human add(Human h) {
		h.age = 100;
		h.name = "홍길동";
		return h;
	}
	
	Human add(Human h, Human h2) {
		h2.age = h.age;
		h2.name = h.name;
		return h2;
	}
}

public class Ex0113_OOP_2 {
	public static void main(String[] args) {
		Test t = new Test();
		Human man = new Human();
		Human woman = new Human();
		
		Human h = t.add(man);
		System.out.println(man.name + "/" + man.age);
		// 이 때 h와 man의 주소는 동일
		// 이 시점에 heap에 올라간 객체는 t, man, woman 세 개이다.
		
		// 문제. 총 학생 수, 점수 합, 평균 구하기
		int sum = 0;
		float average = 0f;
		int[] score = {100, 55, 90, 60, 78};
		
		for(int i : score)
			sum += i;
		average = sum / (float) score.length;
		
		System.out.printf("총 인원 : %d, 총점 : %d, 평균 : %f", score.length, sum, average);
	}
}

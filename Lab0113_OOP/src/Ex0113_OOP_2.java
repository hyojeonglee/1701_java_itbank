class Human {
	int age;
	String name;
}

class Test {
	Human add(Human h) {
		h.age = 100;
		h.name = "ȫ�浿";
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
		// �� �� h�� man�� �ּҴ� ����
		// �� ������ heap�� �ö� ��ü�� t, man, woman �� ���̴�.
		
		// ����. �� �л� ��, ���� ��, ��� ���ϱ�
		int sum = 0;
		float average = 0f;
		int[] score = {100, 55, 90, 60, 78};
		
		for(int i : score)
			sum += i;
		average = sum / (float) score.length;
		
		System.out.printf("�� �ο� : %d, ���� : %d, ��� : %f", score.length, sum, average);
	}
}
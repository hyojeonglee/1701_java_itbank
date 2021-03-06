// 객체 배열
// 잊지말기 : 클래스는 타입이다.
// 배열도 객체다.
class Person {
	String name;
	int age;
}
public class Ex0113_OOP_3 {
	final static int number = 3;
	public static void main(String[] args) {
		Person[] people = new Person[number];
		// 이 때 객체 배열에 효율적으로 객체를 assign하려면 for문을 돌린다.
		for(int i = 0 ; i < number ; i++)
			people[i] = new Person();
		
		// 이런 식으로 해도 됨!
		Person[] people2 = {new Person(), new Person(), new Person()};
		
		// 이차원 배열! [행][열]
		int[][] score = new int[3][2];
		score[0][0] = 90;
		score[0][1] = 100;
		
		score[1][0] = 22;
		score[1][1] = 40;
		
		score[2][0] = 23;
		score[2][1] = 66;
		
		for(int i = 0 ; i < score.length ; i++) {
			for(int j = 0 ; j < score[i].length ; j++) {
				System.out.println(score[i][j]);
			}
		}
		
		// 개선된 for문
		// C# : for(타입 변수명 in 정적배열(배열) 또는 동적배열(컬렉션))
		// Java : for(타입 변수명 : 정적배열(배열) 또는 동적배열(컬렉션))
		String[] strarr = {"가", "나", "다", "라"};
		for(String str : strarr)
			System.out.println(str);
		
		// 센스짱 문제!
		int[][] score3 = new int[][]{
			{11, 12},
			{13, 14},
			{15, 16}
		};
		for(int[] i : score3){
			for(int j : i)
				System.out.println(j);
		}
		
		int[][] score2 = {{90, 100}, {22, 40}, {23, 66}};
	}
}

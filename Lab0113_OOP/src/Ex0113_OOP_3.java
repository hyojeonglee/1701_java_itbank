// ��ü �迭
// �������� : Ŭ������ Ÿ���̴�.
// �迭�� ��ü��.
class Person {
	String name;
	int age;
}
public class Ex0113_OOP_3 {
	final static int number = 3;
	public static void main(String[] args) {
		Person[] people = new Person[number];
		// �� �� ��ü �迭�� ȿ�������� ��ü�� assign�Ϸ��� for���� ������.
		for(int i = 0 ; i < number ; i++)
			people[i] = new Person();
		
		// �̷� ������ �ص� ��!
		Person[] people2 = {new Person(), new Person(), new Person()};
		
		// ������ �迭! [��][��]
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
		
		// ������ for��
		// C# : for(Ÿ�� ������ in �����迭(�迭) �Ǵ� �����迭(�÷���))
		// Java : for(Ÿ�� ������ : �����迭(�迭) �Ǵ� �����迭(�÷���))
		String[] strarr = {"��", "��", "��", "��"};
		for(String str : strarr)
			System.out.println(str);
		
		// ����¯ ����!
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

public class Ex0113_Operators {
	public static void main(String[] args) {
		// <연산 규칙>
		// 자바는 정수의 모든 연산을 int로 변환시킨다!
		// byte + byte => int + int
		byte b = 10;
		byte c = 10;
		// byte d = b + c; 안된다! 경고 메시지 : add cast to "byte"
		// 해결방법
		byte d = (byte)(b + c);
		int e = b + c;
		
		// byte + short => int + int
		// char + char => int + int
		
		// 범위가 큰 것을 따라간다.
		// float + int => float + float
		// float + long => float + float
		// float + double => double + double
		
		// 문제 1. 1 ~ 10까지 짝수의 합 구하기
		int sum = 0;
		for(int i = 1 ; i < 11 ; i++) {
			if (i % 2 == 0)
				sum += i;
		}
		System.out.println(sum);
		
		// 암기! <if문 대신 3항연산자!>
		int p = 10;
		int k = -10;
		int result = (p==10)? p : k;
		
		// <논리 연산자(short circuit 연산을 빨리 해줌)> : && (and) || (or)
		// DB select * from emp where salary > 100 and job != 'sales' or ename = 'king';
		// 이건 안된다! 디비가 싫어한다!
		// DB select * from emp where salary > 100 or job != 'sales';
		
		// if(10 > 0 && -1 > 1 && 100 > 2) {}
		// 위 조건은 -1 > 1에서 거짓이므로 뒤에 아무리 많은 조건이 있어도 안 본다. => 빠르다!
		// if(10 > 0 || -1 > 1 || 100 > 2) {}
		// 위 조건은 10 > 0에서 참이므로 뒤에 있는 조건은 안본다.
		
		// 문제 2. 학점 계산기
		// 학점이 90 이면 A
		// 학점이 90 이상이고 95 이상이면 A+
		// 95 이상이 아닌 나머지는 A-
		// 기준 점수
		int score = 96;
		String grade = "";
		
		if(score >= 90) {
			grade += "A";
			if(score >= 95)
				grade += "+";
			else
				grade += "-";
		}
		
		System.out.println("당신의 학점은 : " + grade);
		
		// <switch 구문> : break는 생략가능
		int s = 80;
		switch(s) {
		case 100:
			System.out.println("100");
			break;
		case 80:
			System.out.println("80");
			break;
		default:
			System.out.println("default");
			break;
		}
	}
}

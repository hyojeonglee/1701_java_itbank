import java.util.StringTokenizer;

// String 관련 함수 - 문제
// Q. String 클래스는 내부적으로 데이터를 어떻게 저장할까?
// A. char array

public class Ex0117_String {
	public static void main(String[] args) {
		String str = "이효정";
		
		// 퀴즈 1
		String result = "cat.jpg"; // 파일명! 또는 cat.jpg, hello.hwp
		char[] array = result.toCharArray();
		int m = 0;
		for(char c : array) {
			m++;
			if(c == '.') {
				System.out.println(result.substring(0, m-1));
				System.out.println(result.substring(m, result.length()));
			}
		}
		
		// 강사님 답
		int position = result.indexOf('.'); // 사용하기
		
		// 퀴즈 2
		String name = "슈퍼맨,팬티,노랑색,우하하,우하하";
		char[] c = name.toCharArray();
		int j = 0;
		int k = 0;
		for(char element : c) {
			j++;
			if(element == ',') {
				System.out.println(name.substring(k, j-1));
				k = j;
			}
		}
		// 답
		String[] namearray = name.split(",");
		
		// 퀴즈 3
		String name2 = "a.b/c,d-f";
		// 답
		StringTokenizer sto = new StringTokenizer(name2, "/.,-");
		while(sto.hasMoreTokens())
			System.out.println(sto.nextToken());
		
		// 퀴즈 4
		String jumin = "123456-1234567";
//		int p4 = name2.indexOf('-');
//		String first = jumin.substring(0, p4-1);
//		String second = jumin.substring(p4+1, jumin.length());
//		
//		System.out.println(Integer.valueOf(first)+Integer.valueOf(second));
//		난 문제 이해 잘못함...
		// 정답
		int sum2 = 0;
		for(int i = 0 ; i < jumin.length() ; i++) {
			String numstr = jumin.substring(i, i+1);
			if(numstr.equals("-"))continue;
			sum2 += Integer.parseInt(numstr);
		}
		System.out.println("주민번호합: " + sum2);
	}
}

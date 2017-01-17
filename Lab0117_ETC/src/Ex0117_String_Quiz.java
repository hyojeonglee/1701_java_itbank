import java.util.Scanner;

// 사용자로부터 주민 번호 입력받을 것
// 유효성 검증 : 14자리 (123456-1234567)
// 남녀 성별 구별 1, 3 남자 2, 4 여자

public class Ex0117_String_Quiz {
	public static void main(String[] args) {
		String id = "";
		do {
			Scanner scan = new Scanner(System.in);
			System.out.print("주민 번호를 입력해주세요 : ");
			id = scan.nextLine();
		} while(!idCheck(id) || !idFirstNumber(id));
		idDisplay(id);
	}
	
	static boolean idCheck(String str) {
		return (str.length()==14 && str.charAt(6) == '-') ? true : false;
	}
	
	static boolean idFirstNumber(String str) {
		int number = getFirstNumber(str);
		return (number > 0 && number < 5) ? true : false;
	}
	
	static int getFirstNumber(String str) {
		// int position = str.indexOf('-');
		// int number = Character.getNumericValue(str.charAt(position + 1));
		int number = Integer.parseInt(str.substring(7, 8)); // 더 간단!
		return number;
	}
	
	static void idDisplay(String str) {
		// 내가 쓴 방법
		int number = getFirstNumber(str);
		String result = (number % 2 == 0)? "여자" : "남자";
		System.out.println(result);
		
		// 강사님
		char cgen = str.replace("-", "").charAt(6);
		switch(cgen) {
		case '1':
		case '3':
			System.out.println("남자");
			break;
		case '2':
		case '4':
			System.out.println("여자");
			break;
		}
	}
}

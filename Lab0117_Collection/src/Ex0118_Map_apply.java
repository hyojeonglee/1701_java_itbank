import java.util.HashMap;
import java.util.Scanner;

// 회원 로그인 처리

public class Ex0118_Map_apply {
	public static void main(String[] args) {
		HashMap loginMap = new HashMap();
		loginMap.put("kim", "kim1004");
		loginMap.put("scott", "tiger");
		
		// 로그인 인증 시스템
		Scanner scan = new Scanner(System.in);
		while(true){
			System.out.print("id 입력 : ");
			String id = scan.nextLine().trim().toLowerCase(); // 양쪽 공백제거, 소문자
			System.out.print("password 입력 : ");
			String pwd = scan.nextLine().trim();
			
//			if(loginMap.containsKey(id)) {
//				String tempPwd = (String) loginMap.get(id);
//				if(pwd.equals(tempPwd)) {
//					System.out.println("로그인 성공!");
//				}
//				else
//					System.out.println("비밀번호가 틀립니다!");
//			}
//			else {
//				System.out.println("회원 아이디가 존재하지 않습니다.");
//			}
			
			// 강사님
			if(!loginMap.containsKey(id)) {
				System.out.println("아이디가 없어요 재입력해주세요");
				continue;
			}
			else {
				if(loginMap.get(id).equals(pwd)) {
					System.out.println("로그인 성공");
					break;
				}
				else {
					System.out.println("패스워드 틀림");
				}
			}
		}
	}
}

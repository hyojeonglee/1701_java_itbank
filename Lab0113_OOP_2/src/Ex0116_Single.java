import kr.or.bank.Singleton;

public class Ex0116_Single {
	// 한 개의 객체를 생성해서 공유한다 = 싱글톤!
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Singleton s = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		Singleton s3 = Singleton.getInstance();
		Singleton s4 = Singleton.getInstance();
		Singleton s5 = Singleton.getInstance();
		Singleton s6 = Singleton.getInstance();
		
		System.out.println(s.toString());
		System.out.println(s == s2);
		System.out.println(s.equals(s2));
		System.out.println(s2.toString());
		System.out.println(s3.toString());
		System.out.println(s4.toString());
		System.out.println(s5.toString());
		System.out.println(s6.toString());
	}

}

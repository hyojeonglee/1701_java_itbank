import java.util.Properties;

// 특수한 형태의 Map! Properties
// but map과 다르게 용도가 정해져 있다.

// 어플리케이션 공통 속성 정의(환경변수) 속성으로 관리!
// 별도의 .properties라는 파일 만들어서 관리하기도 한다.
// 다국어 처리!

// 웹사이트 하단의 관리자 email 주소 (page가 200개 일때 한번에 관리할 수 있다.)
// 또는 경로나 버전 정보
// admin@master.com > admin@star.com

public class Ex0118_Properties {
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("master", "master@gmail.com");
		prop.setProperty("version", "1.0.0");
		prop.setProperty("path", "C:/User/temp/image");
		
		// 웹 사이트 하단에 뿌려지는 것
		// 앱 전체에 뿌려지는 요소를 관리하는데 사용
		System.out.println(prop.getProperty("master"));
		System.out.println(prop.getProperty("version"));
		System.out.println(prop.getProperty("path"));
	}
}

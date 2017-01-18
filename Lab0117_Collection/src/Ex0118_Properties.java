import java.util.Properties;

// Ư���� ������ Map! Properties
// but map�� �ٸ��� �뵵�� ������ �ִ�.

// ���ø����̼� ���� �Ӽ� ����(ȯ�溯��) �Ӽ����� ����!
// ������ .properties��� ���� ���� �����ϱ⵵ �Ѵ�.
// �ٱ��� ó��!

// ������Ʈ �ϴ��� ������ email �ּ� (page�� 200�� �϶� �ѹ��� ������ �� �ִ�.)
// �Ǵ� ��γ� ���� ����
// admin@master.com > admin@star.com

public class Ex0118_Properties {
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("master", "master@gmail.com");
		prop.setProperty("version", "1.0.0");
		prop.setProperty("path", "C:/User/temp/image");
		
		// �� ����Ʈ �ϴܿ� �ѷ����� ��
		// �� ��ü�� �ѷ����� ��Ҹ� �����ϴµ� ���
		System.out.println(prop.getProperty("master"));
		System.out.println(prop.getProperty("version"));
		System.out.println(prop.getProperty("path"));
	}
}

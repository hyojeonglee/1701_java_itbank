// ��� : �� �� ���� �������� ������ �� �ȴ�.
// java : final int NUM = 1000;
// C# : const int NUM = 1000;

// <final Ű����>
// final class FinalClass {} : ����� �� ���� Ŭ����
// final method() : ��� ���迡�� ������(�������̵�) ����!

class Vcard {
	final String KIND = "heart"; // ���
	final int NUM = 100; 
}
//�� ��, ��ü���� �ٸ� ������� ������ ���Ѵٸ�? ***
class Vcard2 {
	final String KIND;
	final int NUM;
	// final String KIND; �̷��� �غ���? ����� �ݵ�� �ʱ�ȭ �ؾߵǴϱ� �Ұ���! ***
	// ����� ��üȭ �� ��, �ٸ� ���� ������ ���ؼ���~
//	public Vcard2() {
//		// this.KIND = "heart"; �굵 �ǹ� ����! ***
//	}
	// ***��!
	public Vcard2(String KIND, int NUM) {
		this.KIND = KIND;
		this.NUM = NUM;
	}
	// ***���� : �� ��, ����Ʈ �����ڴ� �츮�� �� �ȴ�!
}
public class Ex0116_Final {
	public static void main(String[] args) {
		Vcard v = new Vcard();
		// v.KIND = "aaa"; �Ұ���!
		
	}
}

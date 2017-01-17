import java.util.StringTokenizer;

// String ���� �Լ� - ����
// Q. String Ŭ������ ���������� �����͸� ��� �����ұ�?
// A. char array

public class Ex0117_String {
	public static void main(String[] args) {
		String str = "��ȿ��";
		
		// ���� 1
		String result = "cat.jpg"; // ���ϸ�! �Ǵ� cat.jpg, hello.hwp
		char[] array = result.toCharArray();
		int m = 0;
		for(char c : array) {
			m++;
			if(c == '.') {
				System.out.println(result.substring(0, m-1));
				System.out.println(result.substring(m, result.length()));
			}
		}
		
		// ����� ��
		int position = result.indexOf('.'); // ����ϱ�
		
		// ���� 2
		String name = "���۸�,��Ƽ,�����,������,������";
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
		// ��
		String[] namearray = name.split(",");
		
		// ���� 3
		String name2 = "a.b/c,d-f";
		// ��
		StringTokenizer sto = new StringTokenizer(name2, "/.,-");
		while(sto.hasMoreTokens())
			System.out.println(sto.nextToken());
		
		// ���� 4
		String jumin = "123456-1234567";
//		int p4 = name2.indexOf('-');
//		String first = jumin.substring(0, p4-1);
//		String second = jumin.substring(p4+1, jumin.length());
//		
//		System.out.println(Integer.valueOf(first)+Integer.valueOf(second));
//		�� ���� ���� �߸���...
		// ����
		int sum2 = 0;
		for(int i = 0 ; i < jumin.length() ; i++) {
			String numstr = jumin.substring(i, i+1);
			if(numstr.equals("-"))continue;
			sum2 += Integer.parseInt(numstr);
		}
		System.out.println("�ֹι�ȣ��: " + sum2);
	}
}

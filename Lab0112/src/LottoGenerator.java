import kr.or.bank.Lotto;

/*Lotto
1. 1~45������ ������ �߻����� 6���� ���� �迭�� ��ƶ�.
2. �迭�� �ִ� 6���� ���� �ߺ����� �ʴ´�.
3. �迭�� �ִ� 6���� ���� ���� ������ ��µǵ���
4. class Lotto { �Լ� }
5. Lotto lotto = new Lotto �غ���

45 1 15 34 2 25

1 2 15 25 34 45*/

public class LottoGenerator {
	public static void main(String[] args) {
		Lotto l = new Lotto(6);
		l.generateLotto();
		l.sortLotto();
		l.printLotto();
	}
}
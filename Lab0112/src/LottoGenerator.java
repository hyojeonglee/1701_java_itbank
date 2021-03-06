import kr.or.bank.Lotto;

/*Lotto
1. 1~45까지의 난수를 발생시켜 6개의 값을 배열에 담아라.
2. 배열에 있는 6개의 값은 중복되지 않는다.
3. 배열에 있는 6개의 값이 작은 순으로 출력되도록
4. class Lotto { 함수 }
5. Lotto lotto = new Lotto 해보기

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
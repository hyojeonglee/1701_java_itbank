package kr.or.bank;
import java.util.Random;

public class Lotto {
	private int [] lotto;
	
	public Lotto(int size) {
		this.lotto = new int[size];
	}
	
	public int[] generateLotto() {
		Random r = new Random();
		for(int i = 0 ; i < lotto.length ; i++) {
			lotto[i] = r.nextInt(45)+1;
			if(i > 0) {
				for(int j = 0 ; j < i ; j++) {
					if (lotto[j] == lotto[i])
						lotto[i] = 45 - lotto[j]; // i--; break;
				}
			}
		}
		return lotto;
	}
	
	public int[] sortLotto() {
		for(int i = 1 ; i < lotto.length ; i++) {
			for(int j = 0 ; j < i ; j++) {
				if (lotto[j] > lotto[i]) {
					int temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp;
				}
			}
		}
		return lotto;
	}
	
	public void printLotto() {
		for(int i = 0 ; i < lotto.length ; i++)
			System.out.print(lotto[i] + " ");
	}
}

import java.util.ArrayList;
import java.util.List;

// <�������̽�>
// �����迭<Collection>�� ����� �� �� �ִ�.
// Java API > Collection
// - ���� : ���, ǥ��, ��Ģ, �Ծ� ����� ����!
// - ISO ���� ǥ��
// - ����Ʈ���� ���� �ܰ� �ֻ� ������ ��ƴ�.

// - '���'�̱� ������ ���������� �ʴ´�.
// - �׷��� ������ ����(Description)�� �߿��ϴ�.
// - ex)
//		up() ���������� ����, down() �Ʒ���
//		�� ��, ǥ���� ������ ���� ȸ��� ���µ� �� �ۿ� ����.

// - ��� : ǥ��ȭ�� ���� ���谡 �����ϴ�.
// - ������ ��� ���� ����� �� �� ����.
// - �������̽��� �ٸ� Ŭ������ �����ؼ� ����� �� �ִ�.

// *�����ϸ�
// 1. ������ ��ü ���� �Ұ� (100% �̿ϼ� �ڵ�)
// 2. ������ ���ؼ��� ��� ����
// 3. �������̽��� ������ �߻��ڿ� ������ ������ �ϵ��� �Ѵ�.
// 4. ���� ��� ����!!! (���� ���� �������̽� ��� ����)
// 5. �׷��� ������ ���� ������ �����ϴ� ���� �ٶ���

// cf. �߻�Ŭ������ ��
//		- ������ : ������ ��ü ���� �Ұ�
//		- ������ : �������̽��� 100% �̿ϼ�������, �߻�Ŭ������ �ϼ��ڵ嵵 ���� �� �ִ�.

interface IA { // MS�� �����ϴ� ��Ÿ�� vs Java�� �տ� I ���� ~able�� ������.
	public static final int AGE = 100; // �������̽� ���ο��� ����� �� �� �ִ�.
	public abstract String Print();
}
// ***�� ��, ��������� ������ �� public �̾���ϰ� static, final�̹Ƿ�
// ***����Ʈ�� �����Ǿ��ִ�! (�Լ��� public, abstract�� ����Ʈ!)
interface IB { // MS�� �����ϴ� ��Ÿ�� vs Java�� �տ� I ���� ~able�� ������.
	int AGE = 100; // �������̽� ���ο��� ����� �� �� �ִ�.
	String Print();
}

interface IC { // MS�� �����ϴ� ��Ÿ�� vs Java�� �տ� I ���� ~able�� ������.
	void run();
}

// �������̽��� �������̽� ����� �� �ִ�.

class Test implements IA {

	@Override
	public String Print() {
		// TODO Auto-generated method stub
		return null;
	}
}

class Test2 extends Object implements IA, IB, IC {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String Print() {
		// TODO Auto-generated method stub
		return null;
	}
}

// �������̽��� Spring Framework���� ���� ����!
// �������� �����ӿ�ũ https://www.egovframe.go.kr/
// ����������� ����ϴ� �����ӿ�ũ ���� ���� ����!

public class Ex0117_Interface {
	public static void main(String[] args) {
		// ��� List �������̽��� ������ �����̴�!
		// ArrayList<String> list = new ArrayList<>(); �׷��� �� �ڵ庸�ٴ�
		List<String> list = new ArrayList<>(); // �̰� ����.
		
		
	}
}

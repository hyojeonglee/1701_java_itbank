import kr.or.bank.Emp;
import kr.or.bank.AirPlane;

// Ŭ���� ������ �ʱ�ȭ ���ص� ������, ���������� �ʱ�ȭ �ʼ�
public class Ex0113_Ref_type {
	public static void main(String[] args) {
		Emp e = new Emp(1000, "��ȿ��", "01022224545");
		e.empPrint();
		
		// ����
		AirPlane a1 = new AirPlane("���ֵ�","120");
		AirPlane a2 = new AirPlane("����","125");
		AirPlane a3 = new AirPlane("ȫ��","130");
		
		a1.printAirPlane();
		a1.printAllNum();
	}
}
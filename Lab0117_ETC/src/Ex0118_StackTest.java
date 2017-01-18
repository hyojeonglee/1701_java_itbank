import kr.or.bank.MyStack;

public class Ex0118_StackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack s = new MyStack(10);
		s.push(100);
		s.push(200);
		s.push(300);
		s.push(400);
		
		System.out.println(s.pop());
		System.out.println(s.pop());
	}

}

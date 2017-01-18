import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Inner Class의 활용!

class MyFrame extends Frame {
	public MyFrame(String title) {
		super(title);
	}
}

//class BtnClickHandler implements ActionListener {
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		System.out.println("버튼이 눌렸다.");
//	}
//}

public class Ex0118_awt_frame {
	public static void main(String[] args) {
		MyFrame my = new MyFrame("mylogin");
		my.setSize(350, 300);
		my.setVisible(true);
		my.setLayout(new FlowLayout()); // 배치 레이아웃
		
		Button btn = new Button("버튼이다.");
		
		// 1번!
//		BtnClickHandler bclick = new BtnClickHandler();
//		btn.addActionListener(bclick);
//		
//		// 2번!
//		btn.addActionListener(new BtnClickHandler()); // 버튼 이벤트 처리
		btn.setSize(60,  80);
		TextField txtid = new TextField("ID 입력");
		TextField txtpwd = new TextField(0);
		txtpwd.setSize(80, 60);
		txtpwd.setEchoChar('*');
		
		// 3단계. 익명 클래스 사용하기!
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("익명클래스로 인터페이스를 직접 구현함!");
			}
			
		});
		
		// 넷빈즈 쓰면 마우스로 drag&drop 가능
		my.add(btn);
		my.add(txtid);
		my.add(txtpwd);
	}
}

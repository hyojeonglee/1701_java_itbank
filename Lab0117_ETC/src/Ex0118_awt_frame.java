import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Inner Class�� Ȱ��!

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
//		System.out.println("��ư�� ���ȴ�.");
//	}
//}

public class Ex0118_awt_frame {
	public static void main(String[] args) {
		MyFrame my = new MyFrame("mylogin");
		my.setSize(350, 300);
		my.setVisible(true);
		my.setLayout(new FlowLayout()); // ��ġ ���̾ƿ�
		
		Button btn = new Button("��ư�̴�.");
		
		// 1��!
//		BtnClickHandler bclick = new BtnClickHandler();
//		btn.addActionListener(bclick);
//		
//		// 2��!
//		btn.addActionListener(new BtnClickHandler()); // ��ư �̺�Ʈ ó��
		btn.setSize(60,  80);
		TextField txtid = new TextField("ID �Է�");
		TextField txtpwd = new TextField(0);
		txtpwd.setSize(80, 60);
		txtpwd.setEchoChar('*');
		
		// 3�ܰ�. �͸� Ŭ���� ����ϱ�!
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("�͸�Ŭ������ �������̽��� ���� ������!");
			}
			
		});
		
		// �ݺ��� ���� ���콺�� drag&drop ����
		my.add(btn);
		my.add(txtid);
		my.add(txtpwd);
	}
}

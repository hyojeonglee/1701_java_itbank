import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//��ư�� Ŭ���� �̺�Ʈ ó��
//�������̽� �˻� (ActionListener)
//Handler class 
//class Btn_Handler implements ActionListener{
//
//	//actionPerformed �� ��ư Ŭ���� ȣ��Ǵ� �Լ� 
//	//Btn_Handler > TextField Add > Enter
//	//Btn_Handler > Button Add    > Click 
//	
//	private TextField txtid;
//	private TextField txtpwd;
//	
//	public Btn_Handler(TextField txtid , TextField txtpwd){
//		this.txtid = txtid;
//		this.txtpwd = txtpwd;
//	}
//	
//	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		//txt_id �ԷµȰ� ������ ����
//		//txt_pwd  �ԷµȰ� ������ ����
//		//System.out.println("��ư Ŭ��");
//		//System.out.println(txtid.getText() + "/ " + txtpwd.getText());
//		
//		if(txtid.getText().equals("kglim")){
//			System.out.println("�氡 " + " / " + txtpwd.getText() );
//		}else{
//			System.out.println("�����ִ� �ʴ� ������ ^^");
//		}
//		
//	}
//	
//}
 
// Inner Class�� ���ǹ��� �� �ڵ带 ������!

class LoginForm extends Frame{
	Label lbl_id;
	Label lbl_pwd;
	TextField txt_id;
	TextField txt_pwd;
	Button btn_ok;
	
	public LoginForm(String title){
		super(title);
		lbl_id = new Label("ID:",Label.RIGHT);
		lbl_pwd = new Label("PWD:",Label.RIGHT);
		txt_id = new TextField(10);
		txt_pwd = new TextField(10);
		txt_pwd.setEchoChar('#');
		btn_ok = new Button("login");
		
		
		this.setLayout(new FlowLayout());//�������
		this.setSize(500, 100);
		this.setVisible(true);
		
		this.add(lbl_id);
		this.add(txt_id);
		this.add(lbl_pwd);
		this.add(txt_pwd);
		this.add(btn_ok);
		
		// �̺�Ʈ ó��
		// this.btn_ok.addActionListener(new Btn_Handler(txt_id, txt_pwd));
		
		// Inner Class�� ����
		this.btn_ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!txt_id.getText().equals("kglim")){
					System.out.println("��ȿ���� ���� ID");
					txt_id.requestFocus();
					txt_id.selectAll();
				}else if(!txt_pwd.getText().equals("1004")){
					System.out.println("��ȿ���� ���� PWD");
					txt_pwd.requestFocus();
					txt_pwd.selectAll();
				}else{
					System.out.println("�α��� ����!!!");
				}
			}
		});
		
		//--------------close ��� ����--------------//
		// �̷����ϸ� windowClosing() �ϳ��� ���ǵ� �� �����... ����! ����� ����ϱ�!
//		this.addWindowListener(new WindowListener() {
//
//			@Override
//			public void windowOpened(WindowEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void windowClosing(WindowEvent e) {
//				// TODO Auto-generated method stub
//				e.getWindow().setVisible(false);
//				e.getWindow().dispose();
//			}
//
//			@Override
//			public void windowClosed(WindowEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void windowIconified(WindowEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void windowDeiconified(WindowEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void windowActivated(WindowEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void windowDeactivated(WindowEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//		});
		
		// ����ͷ� ���� (��!)
		this.addWindowListener(new WindowAdapter() {
			// ���콺 ��Ŭ������ ����!
			// Adapter�� ������ �ϰ���� �͸� �϶�� public���� �� �����صξ���.
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				e.getWindow().setVisible(false);
				e.getWindow().dispose();
			}
			
		});
	}
	
}

public class Ex12_Button_Event_InnerClass {
	public static void main(String[] args) {
		LoginForm loginform = new LoginForm("login");
	}
}

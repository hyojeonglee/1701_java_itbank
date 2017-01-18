import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//버튼을 클릭시 이벤트 처리
//인터페이스 검색 (ActionListener)
//Handler class 
//class Btn_Handler implements ActionListener{
//
//	//actionPerformed 는 버튼 클릭시 호출되는 함수 
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
//		//txt_id 입력된값 가지고 오기
//		//txt_pwd  입력된값 가지고 오기
//		//System.out.println("버튼 클릭");
//		//System.out.println(txtid.getText() + "/ " + txtpwd.getText());
//		
//		if(txtid.getText().equals("kglim")){
//			System.out.println("방가 " + " / " + txtpwd.getText() );
//		}else{
//			System.out.println("졸고있는 너는 누구냐 ^^");
//		}
//		
//	}
//	
//}
 
// Inner Class로 무의미한 위 코드를 삭제함!

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
		
		
		this.setLayout(new FlowLayout());//순서대로
		this.setSize(500, 100);
		this.setVisible(true);
		
		this.add(lbl_id);
		this.add(txt_id);
		this.add(lbl_pwd);
		this.add(txt_pwd);
		this.add(btn_ok);
		
		// 이벤트 처리
		// this.btn_ok.addActionListener(new Btn_Handler(txt_id, txt_pwd));
		
		// Inner Class로 개선
		this.btn_ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!txt_id.getText().equals("kglim")){
					System.out.println("유효하지 않은 ID");
					txt_id.requestFocus();
					txt_id.selectAll();
				}else if(!txt_pwd.getText().equals("1004")){
					System.out.println("유효하지 않은 PWD");
					txt_pwd.requestFocus();
					txt_pwd.selectAll();
				}else{
					System.out.println("로그인 성공!!!");
				}
			}
		});
		
		//--------------close 기능 구현--------------//
		// 이렇게하면 windowClosing() 하나만 쓸건데 다 써야함... 개선! 어댑터 사용하기!
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
		
		// 어댑터로 구현 (굿!)
		this.addWindowListener(new WindowAdapter() {
			// 마우스 우클릭으로 가능!
			// Adapter는 재정의 하고싶은 것만 하라고 public으로 다 오픈해두었다.
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

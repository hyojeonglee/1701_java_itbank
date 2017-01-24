import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

//UI 작업 (swing)


public class Ex07_TCP_Multi_Client extends JFrame implements ActionListener , Runnable{
	 JTextArea ta;//출력창
	 JTextField txtinput; //입력창
	 DataInputStream in;
	 DataOutputStream out;
	 
	 public Ex07_TCP_Multi_Client(){
		 //UI 및 객체 초기화
		 this.setTitle("Multi 채팅");
		 ta = new JTextArea();
		 txtinput = new JTextField();
		 JScrollPane sp = new JScrollPane(ta,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				                         ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		 sp.setAutoscrolls(true);
		 ta.setBackground(Color.yellow);
		 ta.setLineWrap(true);//텍스트 자동 줄바꿈
		 ta.setEditable(false); //TextArea 편집 안됨
		 
		 txtinput.setText("대화 입력창");
		 
		 this.add(sp,"Center");
		 this.add(txtinput, "South");
		 this.setSize(400,500);
		 this.setVisible(true);
		 
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		 txtinput.requestFocus();
		 txtinput.selectAll();
		 
		 //이벤트 처리
		 txtinput.addActionListener(this);
		 
		 try{
			 Socket socket = new Socket("192.168.137.1", 9999);
			 in = new DataInputStream(socket.getInputStream());
			 out = new DataOutputStream(socket.getOutputStream());
			 //서버와 연결
			 ta.append("서버에 접속 되었습니다\r\n");
			 
			 Thread thread = new Thread(this);
			 thread.start();
		 }catch (Exception e) {
			System.out.println(e.getMessage());
		}
		 
		 
		 
	 }
	 
	public static void main(String[] args) {
		Ex07_TCP_Multi_Client client = new Ex07_TCP_Multi_Client();

	}

	@Override
	public void run() {
		try{
			String msg = in.readUTF();
			ta.append(msg + "\r\n");
			while(in != null){
				msg = in.readUTF();
				ta.append(msg + "\r\n");
			}
		}catch(Exception e){
			System.out.println("접속중 서버와 연결 종료");
			return;
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//TextField 입력하고 Enter 처리하면
		//e.getSource  > TextField
		if(e.getSource().equals(txtinput)){
			
			String msg = txtinput.getText();
			System.out.println(msg);
			try{
				out.writeUTF(msg); //입력한 내용을 서버로 전송
				txtinput.setText("");
				
			}catch(Exception x){
				System.out.println(x.getMessage());
			}
		}
		
	}

}

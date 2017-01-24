import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

// UI 작업(swing)
// awt : OS 자원 사용 / swing : 순수하게 자바 자원 사용, 이름 앞에 J가 붙는다.

public class Ex07_TCP_Multi_Client extends JFrame implements ActionListener, Runnable {
	JTextArea ta; // 출력창
	JTextField txtInput; // 입력창
	DataInputStream in;
	DataOutputStream out;
	
	public Ex07_TCP_Multi_Client() {
		// UI 및 객체 초기화
		this.setTitle("멀티 채팅");
		ta = new JTextArea();
		txtInput = new JTextField();
		JScrollPane sp = new JScrollPane(ta, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setAutoscrolls(true);
		ta.setBackground(Color.yellow);
		ta.setLineWrap(true); // Text자동 줄바꿈 처리!
		ta.setEditable(false); // TextArea 편집 안됨!
		
		txtInput.setText("대화 입력창");
		
		this.add(sp, "Center");
		this.add(txtInput, "South");
		this.setSize(400, 500);
		this.setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		txtInput.requestFocus(); // 처음 켰을 때, 포커스 여기로
		txtInput.selectAll();
		
		// 이벤트 처리!
		txtInput.addActionListener(this);
		
		// 소켓 설정
		try {
			Socket socket = new Socket("192.168.101.1", 9999);
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			// 서버와 연결!
			ta.append("서버에 접속되었습니다.\r\n");
			
			Thread thread = new Thread(this);
			thread.start();
		} catch(Exception e) {
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex07_TCP_Multi_Client();
	}


	@Override
	public void run() {
		try {
			String msg = in.readUTF();
			ta.append(msg); // 서버로부터 읽어서 textArea에 추가
			while(in != null) {
				msg = in.readUTF();
				ta.append(msg + "\r\n");
			}
		} catch(Exception e) {
			System.out.println("접속 중 서버와 연결 종료");
			return; // run 함수 탈출!
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TextField 입력하고 Enter 처리하면 동작!
		// e.getSource > TextField
		if(e.getSource().equals(txtInput)) {
			String msg = txtInput.getText();
			try {
				out.writeUTF(msg); // 입력한 내용을 서버로 전송!
				txtInput.setText("");
			} catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
		}		
	}
}

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

// UI �۾�(swing)
// awt : OS �ڿ� ��� / swing : �����ϰ� �ڹ� �ڿ� ���, �̸� �տ� J�� �ٴ´�.

public class Ex07_TCP_Multi_Client extends JFrame implements ActionListener, Runnable {
	JTextArea ta; // ���â
	JTextField txtInput; // �Է�â
	DataInputStream in;
	DataOutputStream out;
	
	public Ex07_TCP_Multi_Client() {
		// UI �� ��ü �ʱ�ȭ
		this.setTitle("��Ƽ ä��");
		ta = new JTextArea();
		txtInput = new JTextField();
		JScrollPane sp = new JScrollPane(ta, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setAutoscrolls(true);
		ta.setBackground(Color.yellow);
		ta.setLineWrap(true); // Text�ڵ� �ٹٲ� ó��!
		ta.setEditable(false); // TextArea ���� �ȵ�!
		
		txtInput.setText("��ȭ �Է�â");
		
		this.add(sp, "Center");
		this.add(txtInput, "South");
		this.setSize(400, 500);
		this.setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		txtInput.requestFocus(); // ó�� ���� ��, ��Ŀ�� �����
		txtInput.selectAll();
		
		// �̺�Ʈ ó��!
		txtInput.addActionListener(this);
		
		// ���� ����
		try {
			Socket socket = new Socket("192.168.101.1", 9999);
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			// ������ ����!
			ta.append("������ ���ӵǾ����ϴ�.\r\n");
			
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
			ta.append(msg); // �����κ��� �о textArea�� �߰�
			while(in != null) {
				msg = in.readUTF();
				ta.append(msg + "\r\n");
			}
		} catch(Exception e) {
			System.out.println("���� �� ������ ���� ����");
			return; // run �Լ� Ż��!
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TextField �Է��ϰ� Enter ó���ϸ� ����!
		// e.getSource > TextField
		if(e.getSource().equals(txtInput)) {
			String msg = txtInput.getText();
			try {
				out.writeUTF(msg); // �Է��� ������ ������ ����!
				txtInput.setText("");
			} catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
		}		
	}
}

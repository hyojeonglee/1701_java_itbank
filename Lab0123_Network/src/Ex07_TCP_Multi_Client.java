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

//UI �۾� (swing)


public class Ex07_TCP_Multi_Client extends JFrame implements ActionListener , Runnable{
	 JTextArea ta;//���â
	 JTextField txtinput; //�Է�â
	 DataInputStream in;
	 DataOutputStream out;
	 
	 public Ex07_TCP_Multi_Client(){
		 //UI �� ��ü �ʱ�ȭ
		 this.setTitle("Multi ä��");
		 ta = new JTextArea();
		 txtinput = new JTextField();
		 JScrollPane sp = new JScrollPane(ta,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				                         ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		 sp.setAutoscrolls(true);
		 ta.setBackground(Color.yellow);
		 ta.setLineWrap(true);//�ؽ�Ʈ �ڵ� �ٹٲ�
		 ta.setEditable(false); //TextArea ���� �ȵ�
		 
		 txtinput.setText("��ȭ �Է�â");
		 
		 this.add(sp,"Center");
		 this.add(txtinput, "South");
		 this.setSize(400,500);
		 this.setVisible(true);
		 
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		 txtinput.requestFocus();
		 txtinput.selectAll();
		 
		 //�̺�Ʈ ó��
		 txtinput.addActionListener(this);
		 
		 try{
			 Socket socket = new Socket("192.168.137.1", 9999);
			 in = new DataInputStream(socket.getInputStream());
			 out = new DataOutputStream(socket.getOutputStream());
			 //������ ����
			 ta.append("������ ���� �Ǿ����ϴ�\r\n");
			 
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
			System.out.println("������ ������ ���� ����");
			return;
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//TextField �Է��ϰ� Enter ó���ϸ�
		//e.getSource  > TextField
		if(e.getSource().equals(txtinput)){
			
			String msg = txtinput.getText();
			System.out.println(msg);
			try{
				out.writeUTF(msg); //�Է��� ������ ������ ����
				txtinput.setText("");
				
			}catch(Exception x){
				System.out.println(x.getMessage());
			}
		}
		
	}

}

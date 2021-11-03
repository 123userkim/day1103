package com.sist.chat;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ChatClient extends JFrame implements ActionListener {
	
	//��ȭ������ ����� �ؽ�Ʈ����� �ɹ������� ������
	JTextArea jta;
	
	//���� ��ȭ������ �Է��� �ؽ�Ʈ�ʵ带 �ɹ������� ������
	JTextField jtf;
	
	//����½�Ʈ���� �ɹ������� ������
	InputStream is;
	OutputStream os;
	
	public ChatClient() {
		
		
		//�ɹ����� �ؽ�Ʈ������� �ؽ�Ʈ�ʵ带 �����մϴ�.
		jta = new JTextArea();
		jtf = new JTextField();
		
		
		//"����"�� ���� ��ư�� �����մϴ�.
		JButton btn = new JButton("����");
		
		//��ư�� �̺�Ʈ�� ����մϴ�.
		btn.addActionListener(this);
		
		//�ؽ�Ʈ�ʵ�� ��ư�� ������� �г��� �����մϴ�.
		JPanel p = new JPanel();
		
		//�г��� ���̾ƿ������ BorderLayout���� �����մϴ�.
		p.setLayout(new BorderLayout());
		
		p.add(jtf, BorderLayout.CENTER);
		p.add(btn, BorderLayout.EAST);
		
		//�ؽ�Ʈ����� ��ũ�������� ���ο�
		JScrollPane jsp = new JScrollPane(jta);
		
		//�������� ����� �ؽ�Ʈ����� ���ΰ� �ִ� ��ũ������ ��ƿ�
		add(jsp,BorderLayout.CENTER);
		
		//�ؽ�Ʈ�ʵ�� ��ư�� ��� �ִ� �г��� �������� �Ʒ��� ��ƿ�
		add(p,BorderLayout.SOUTH);
		
		//�������� ũ�⸦ �����մϴ�.
		setSize(800,600);
		
		//�������� ȭ�鿡 ���̵��� �����մϴ�.
		setVisible(true);
		
		try {
			
			//����� ���Ͽ� ������ ������ ��û�Ѵ�.
			Socket socket = new Socket("222.120.183.156", 9003);
			
			//������� ���� ��Ʈ���� �����մϴ�.
			is = socket.getInputStream();
			os = socket.getOutputStream();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		//������ �������� �����͸� ����Ͽ� �ޱ� ���� ������ Ŭ������ ����� ���ô�.
		//Ŭ���� �ȿ� �ִ� Ŭ������ innerŬ������ �ϰ� 
		//�ٱ��� �ִ� Ŭ������ outterŬ������� �մϴ�.
		//innerŬ������ ��ġ outterŬ���� �ɹ�ó�� �����ؿ�
		//outterŬ������ �ɹ��� �����Ӱ� ������ �� �־��.
		 
		
		
		
		
		
		
		
		//���� �̳ʸ� ���� �� ��ó�� Ŭ�����̸��� �������� �����ְ� ���� ���� ������
		//��κ��� ��� Ŭ�����̸��� �� �����ְ�, �̸����� Ŭ������ �����ϰ� �ٷ� ��ü�� ������
		//new �������̽��̸�(){  �������̵��ؾ��� �޼ҵ��̸�(){}   }
		//�������̽��� ������ Ŭ������ �����ϰ� �ٷ� ��ü���� 
		
		new Thread(     new Runnable() {
			byte []data = new byte[100];		
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true) {
					try {
						//������ ������ �����͸� �����մϴ�.
						is.read(data);
						
						//������ �������� ���ڿ��� ������
						String msg = new String(data);
						
						//������ ���ڿ��� �ؽ�Ʈ����� �߰��մϴ�.
						jta.append(msg.trim()+"\n");
						
					}catch (Exception e) {
						System.out.println("���ܹ߻�:"+e.getMessage());
					}
				}
			}
			
		}).start();
	 
	}//end  ������
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChatClient();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		try {
			//����ڰ� �Է��� �ؽ�Ʈ�ʵ��� ������ ������ �������� �մϴ�.
			//OutputStream void	write(byte[] b) �޼ҵ带 �̿��մϴ�.
			byte []data = jtf.getText().getBytes();
			os.write(data);
			
			//�޼����� �����ϰ� ���� �޼��� �Է��� ���Ͽ� �ؽ�Ʈ�ʵ带 ������ ������
			jtf.setText("");
			
		}catch (Exception ex) {
			System.out.println("���ܹ߻�:"+ex.getMessage());
		}
		
	}
}

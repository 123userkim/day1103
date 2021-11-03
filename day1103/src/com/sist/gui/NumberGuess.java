package com.sist.gui;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.Color;

public class NumberGuess extends JFrame implements ActionListener{
	
	//����ڰ� ���ڸ� �Է��ϱ� ���� �ؽ�Ʈ�ʵ带 �ɹ������� �����մϴ�.
	JTextField jtf;
	
	//����ڰ� �Է��� ���ڰ� ��ǻ�Ͱ� ������ ���ڿ� ���߾����� ��ū�� �� ������ ����� ����� ���� �ɹ������� �����մϴ�.
	JTextField result;
	
	//��ǻ�Ͱ� ������ ������ �����ϱ� ���� ������ �ɹ������� �����մϴ�.
	int num;
	
	
	
	
	public NumberGuess(){
		
		//������ �ϳ� �����Ͽ� �ɹ����� num�� �����մϴ�.
		Random r = new Random();
		num= r.nextInt(100)+1;
		
		//�ɹ����� �ؽ�Ʈ�ʵ�� ���� �����մϴ�.
		jtf = new JTextField(10);
		result = new JTextField("                         ���⿡ ����� ��Ÿ���ϴ�.                    ");
		
		//�������� ��ġ����� �÷ο췹�̿����� �����մϴ�.
		setLayout(new FlowLayout());
		
		//ȭ�鿡 ������ҵ��� ��ƿ�
		add(new JLabel("���ڸ� �����Ͻÿ�"));
		add(jtf);
		add(result);
		
		//�ΰ��� ��ư�� �����մϴ�.
		JButton btn01 = new JButton("�ٽ� �ѹ�");
		JButton btn02 = new JButton("����");
		add(btn01);
		add(btn02);
		
		//�������� ũ��� ȭ�鿡 ���̵��� �����մϴ�.
		setSize(300,300);
		setVisible(true);
		
		//â�� ������ ���α׷��� �����ϵ��� �����մϴ�.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//â�� ũ�⸦ �������� ���ϵ��� ������
		setResizable(false);
		
		//�ΰ��� ��ư�� �̺�Ʈ�� ����մϴ�.
		btn01.addActionListener(this);
		btn02.addActionListener(this);
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new NumberGuess();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//"�ٽ� �ѹ�" ��ư�� ������ "����" ��ư�� ������ �� �޼ҵ尡 �����մϴ�.
		//�׷��� � ��ư�� ���������� �Ǵ��ؾ� �մϴ�.
		//�׷��� �ϱ� ���ؼ� �Ű����� ActionEvent�� getActionCommand �޼ҵ带 ���� ��ư�� ������ ���ڸ� �о�ɴϴ�.
		String cmd = e.getActionCommand();
		if(cmd.equals("�ٽ� �ѹ�")) {
			//��ǻ�� �����ϰ� �ִ� ������ ����ڰ� �Է��� ���ڰ� ������ �Ǻ��մϴ�.
			
			//����ڰ� �Է��� ���ڸ� ���� �ɴϴ�.
			int user = Integer.parseInt(jtf.getText());
			
			//������, ��ū��, �� ������ �Ǻ��Ͽ� ����� ����մϴ�.
			if(user == num) {
				result.setText("                         �����Դϴ�!                    ");
				result.setBackground(Color.BLUE);
			}else if(user > num) {
				result.setText("                      �� ū ���ڸ� �Է��߾��!                    ");
				jtf.setText("");
				result.setBackground(Color.RED);
			}else {
				result.setText("                      �� ���� ���ڸ� �Է��߾��!                ");
				jtf.setText("");
				result.setBackground(Color.RED);
			}
			
			
		}else if(cmd.equals("����")) {
			System.exit(0);
		}
	}

}
package com.sist.inner;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;
//��ư�� ���� �̺�Ʈó���� ���ؼ� ActionLisetener InterFace�� �����ؾ���
//���� MyFrame �ڽ��� ActionLisetener�������̽��� �����ϰԵǸ� �ϳ��� Actionperformed �̺�Ʈ ó���� �ؾ���
//������ ���� ���������� �Ǵ��ϴ�  if�� �������� -> ��ư �ϳ��� ��ó�� ��� ��ü�� �̸����� �̳�Ŭ������ ���� ó����
import java.rmi.MarshalledObject;
import java.rmi.Remote;
import java.rmi.RemoteException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {
	
	
	public MyFrame() {
		
		
		JButton button01= new JButton("����");
		JButton button02= new JButton("����");
		
		setLayout(new FlowLayout());

		add(button01);
		add(button02);
		
		setSize(400,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//�̸����� ��ü�� ������ ()   {Ŭ���� ���Ǹ� ����}
		button01.addActionListener(            new ActionListener  () {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				 System.out.println("�����Դϴ�");
			}
			
		});
		
		
		//�̸����� ��ü�� ������ ()   {Ŭ���� ���Ǹ� ����}
		button02.addActionListener(            new ActionListener  () {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					 System.out.println("�����Դϴ�");
				}
			
		});
		
		
		
		
			
	} 
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyFrame();

	}

}

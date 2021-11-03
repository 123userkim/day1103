package com.sist.inner;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;
//버튼에 대한 이벤트처리를 위해선 ActionLisetener InterFace를 구현해야함
//만약 MyFrame 자신이 ActionLisetener인터페이스를 구현하게되면 하나의 Actionperformed 이벤트 처리를 해야함
//일일이 누가 눌러졌는지 판단하는  if가 복잡해짐 -> 버튼 하나당 일처리 담당 객체를 이름없는 이너클래스로 만들어서 처리함
import java.rmi.MarshalledObject;
import java.rmi.Remote;
import java.rmi.RemoteException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {
	
	
	public MyFrame() {
		
		
		JButton button01= new JButton("남자");
		JButton button02= new JButton("여자");
		
		setLayout(new FlowLayout());

		add(button01);
		add(button02);
		
		setSize(400,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//이름없는 객체를 생성함 ()   {클래스 정의를 위한}
		button01.addActionListener(            new ActionListener  () {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				 System.out.println("남자입니다");
			}
			
		});
		
		
		//이름없는 객체를 생성함 ()   {클래스 정의를 위한}
		button02.addActionListener(            new ActionListener  () {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					 System.out.println("여자입니다");
				}
			
		});
		
		
		
		
			
	} 
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyFrame();

	}

}

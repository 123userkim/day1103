package com.sist.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AllStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	try { 
	String sql = "select * from student";
			
			
	//1. jdbc ����̹��� �޸𸮷� �ε��ϱ�
	Class.forName("oracle.jdbc.driver.OracleDriver"); 
	
	//2. db������ ������
	Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.68:1521:XE","c##sist", "sist");
	//3. statement ��ü�� �����ϱ�
	Statement stmt = conn.createStatement();
	
	//4. dataBase ����� ������
	ResultSet rs =stmt.executeQuery(sql);
	
	//5. ���ڵ尡 �ִ� ��ŭ Ŀ���� �� �྿ �ű��
	while(rs.next()) {
		//getString(1); 
		//columIndex
		String name = rs.getString(1);
		int kor = rs.getInt(2);
		int eng = rs.getInt(3);
		int math = rs.getInt(4);
		System.out.println(name +","+ kor +"," +eng+","+math);
		
	
	}
	
	//6. ����� �ڿ��� �ݾ���
			rs.close();
			stmt.close();
			conn.close();
	
		}catch(Exception e) {
			System.out.println("���ܹ߻� : "+e.getMessage());
		}
	}

}

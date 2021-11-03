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
			
			
	//1. jdbc 드라이버를 메모리로 로드하기
	Class.forName("oracle.jdbc.driver.OracleDriver"); 
	
	//2. db서버에 연결함
	Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.68:1521:XE","c##sist", "sist");
	//3. statement 객체를 생성하기
	Statement stmt = conn.createStatement();
	
	//4. dataBase 명령을 실행함
	ResultSet rs =stmt.executeQuery(sql);
	
	//5. 레코드가 있는 만큼 커서를 한 행씩 옮긴다
	while(rs.next()) {
		//getString(1); 
		//columIndex
		String name = rs.getString(1);
		int kor = rs.getInt(2);
		int eng = rs.getInt(3);
		int math = rs.getInt(4);
		System.out.println(name +","+ kor +"," +eng+","+math);
		
	
	}
	
	//6. 사용한 자원을 닫아줌
			rs.close();
			stmt.close();
			conn.close();
	
		}catch(Exception e) {
			System.out.println("예외발생 : "+e.getMessage());
		}
	}

}

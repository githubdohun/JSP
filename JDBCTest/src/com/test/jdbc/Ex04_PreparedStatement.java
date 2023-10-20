package com.test.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Ex04_PreparedStatement {
	
	public static void main(String[] args) {
		
		m1();
		
	}

	private static void m1() {
		
		//Statement vs PreparedStatement
		//- Statement > 정적 SQL(매개변수 X)
		//- PreparedStatement > 동적 SQL(매개변수 O)
		
		//PreparedStatement 장점
		//1. 매개변수 관리 용이
		//2. 매개변수 유효성 처리
		
		String sql = "insert into tblAddress (seq, name, age, gender, address, regdate) values (seqAddress.nextVal, '아무개', 22, 'm', '서울시 강남구 대치동', default)";
		//정적 SQL
		
		//정적 SQL
		sql = "insert into tblAddress (seq, name, age, gender, address, regdate) values (seqAddress.nextVal, '%s', %s, '%s', '%s', default)";
		
		//동적 SQL
		sql = "insert into tblAddress (seq, name, age, gender, address, regdate) values (seqAddress.nextVal, ?, ?, ?, ?, default)";
		
		
		
		String name = "하하하";
		String age = "20";
		String gender = "m";
		String address = "서울시 강남구 역삼동's 아파트";
		
//		name = name.replace("'", "''");
//		address = address.replace("'", "''");
		
		Connection conn = null;
		Statement stat = null;
		PreparedStatement pstat = null;
		
		try {
			
			conn = DBUtil.open();
			
//			sql = String.format("insert into tblAddress (seq, name, age, gender, address, regdate) values (seqAddress.nextVal, '%s', %s, '%s', '%s', default)", name, age, gender, address);
//			
//			stat = conn.createStatement();
//			
//			int result = stat.executeUpdate(sql);
//			
//			System.out.println(result);
			
			sql = "insert into tblAddress (seq, name, age, gender, address, regdate) values (seqAddress.nextVal, ?, ?, ?, ?, default)";
			
			pstat = conn.prepareStatement(sql);
			
			//pstat > 매개변수를 관리하는 역할 겸함
			pstat.setString(1, name); //첫번째 ?에 name을 넣어라
			pstat.setString(2, age);
			pstat.setString(3, gender);
			pstat.setString(4, address);
			
			int result = pstat.executeUpdate();
			
			System.out.println(result);
			
			pstat.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}//m1
}

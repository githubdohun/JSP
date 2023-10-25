package com.test.ajax.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AjaxDAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public AjaxDAO() {
		this.conn = DBUtil.open();
	}

	public int getMemoCount() {
		
	try {
		
		String sql = "select count(*) as cnt from tblMemo";
		
		stat = conn.createStatement();
		
		rs = stat.executeQuery(sql);
		
		if (rs.next()) {
			return rs.getInt("cnt");
		}
		
	} catch (Exception e) {
		System.out.println("AjaxDAO.getMemoCount()");
		e.printStackTrace();
	}
		
		return 0;
	}

	public int getMemoCount(String name) {
		
		try {
			
			String sql = String.format("select count(*) as cnt from tblMemo where name = '%s'", name);
			
			stat = conn.createStatement();
			
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				return rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			System.out.println("AjaxDAO.getMemoCount()");
			e.printStackTrace();
		}
		
		
		return 0;
	}

}

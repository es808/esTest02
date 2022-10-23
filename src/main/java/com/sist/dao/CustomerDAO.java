package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sist.vo.CustomerVO;

public class CustomerDAO {
	final String DRIVER_NAME="oracle.jdbc.driver.OracleDriver";
	final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	final String USER="c##madang";
	final String PWD="madang";
	
	public CustomerDAO() {
		try {
			Class.forName(DRIVER_NAME);
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
	
	//회원가입
	public int insertCustomer(CustomerVO c) {
		int re=-1;
		String sql="insert into insertcust(custid,pwd,name,phone,email,birth,gender,favor) values(?,?,?,?,?,?,?,?)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DriverManager.getConnection(URL,USER,PWD);
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, c.getCustid());
			pstmt.setString(2, c.getPwd());
			pstmt.setString(3, c.getName());
			pstmt.setString(4, c.getPhone());
			pstmt.setString(5, c.getEmail());
			pstmt.setString(6, c.getBirth());
			pstmt.setString(7, c.getGender());
			pstmt.setString(8, c.getFavor());
			re=pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		} finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return re;
	}
}

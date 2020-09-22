package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

	public static boolean checkEmailExistsOrNot(String e) throws ClassNotFoundException, SQLException {
		Connection con = ConnectionUtility.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from user where email=?");
		ps.setString(1, e);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			return true;
		}

		return false;
	}

	public static boolean insertUserDetails(String n, String e, String p) throws ClassNotFoundException, SQLException {
		Connection con = ConnectionUtility.getConnection();
		PreparedStatement ps = con.prepareStatement("insert into user (name,email,password) values (?,?,?)");
		ps.setString(1, n);
		ps.setString(2, e);
		ps.setString(3, p);
		int val = ps.executeUpdate();
		if (val > 0) {
			return true;
		}
		return false;
	}

	public static boolean checkLogin(String e, String p) throws ClassNotFoundException, SQLException {
		Connection con = ConnectionUtility.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from user where email=? && password=?");
		ps.setString(1, e);
		ps.setString(2, p);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			return true;
		}
		return false;
	}

	public static String getNameUsingEmail(String e) throws ClassNotFoundException, SQLException {
		Connection con = ConnectionUtility.getConnection();
		PreparedStatement ps = con.prepareStatement("select name from user where email=?");
		ps.setString(1, e);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			return rs.getString(1);
		}
		return null;
	}

	public static int getUserIdByEmail(String e) throws ClassNotFoundException, SQLException {
		Connection con = ConnectionUtility.getConnection();
		PreparedStatement ps = con.prepareStatement("select id from user where email=?");
		ps.setString(1, e);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
			return rs.getInt(1);
		
		return 0;
	}

}

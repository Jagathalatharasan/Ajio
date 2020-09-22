package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class OrdersDao {

	public static boolean insertOrder(int userId, int totalPrice, Timestamp ts) throws ClassNotFoundException, SQLException {
		Connection con = ConnectionUtility.getConnection();
		PreparedStatement ps = con.prepareStatement("insert into orders (user_id,total_amount,order_date) values (?,?,?)");
		ps.setInt(1, userId);
		ps.setInt(2, totalPrice);
		ps.setTimestamp(3, ts);
		int val=ps.executeUpdate();
		if(val>0)
			return true;
		
		return false;
	}

	public static int getOrderIdByUserIdAndTime(int userId, Timestamp ts) throws ClassNotFoundException, SQLException {
		Connection con = ConnectionUtility.getConnection();
		PreparedStatement ps = con.prepareStatement("select id from orders where user_id=? && order_date=?");
		ps.setInt(1, userId);
		ps.setTimestamp(2, ts);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
			return rs.getInt(1);
		
		return 0;
	}

}

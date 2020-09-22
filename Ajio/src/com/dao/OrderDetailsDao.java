package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDetailsDao {

	public static boolean insertDetailsIntoTable(int orderId, int id, int parseInt)
			throws SQLException, ClassNotFoundException {
		Connection con = ConnectionUtility.getConnection();
		PreparedStatement ps = con
				.prepareStatement("insert into order_details (order_id,product_id,quantity) values (?,?,?)");
		ps.setInt(1, orderId);
		ps.setInt(2, id);
		ps.setInt(3, parseInt);
		int val = ps.executeUpdate();
		if (val > 0)
			return true;

		return false;
	}

}

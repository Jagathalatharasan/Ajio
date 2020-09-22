package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.ProductDto;

public class ProductDao {

	public static List<String> getAllCategories() throws ClassNotFoundException, SQLException {
		Connection con = ConnectionUtility.getConnection();
		PreparedStatement ps = con.prepareStatement("select distinct category from product");
		ResultSet rs = ps.executeQuery();
		List<String> cList = new ArrayList<String>();
		while (rs.next()) {
			cList.add(rs.getString(1));
		}

		return cList;
	}

	public static List<ProductDto> getAllProducts() throws ClassNotFoundException, SQLException {
		Connection con = ConnectionUtility.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from product");
		ResultSet rs = ps.executeQuery();
		List<ProductDto> pList = new ArrayList<ProductDto>();
		ProductDto p = null;
		while (rs.next()) {
			p = new ProductDto(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
			pList.add(p);
		}
		return pList;
	}

	public static List<ProductDto> getCategoryValues(String c) throws ClassNotFoundException, SQLException {
		Connection con = ConnectionUtility.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from product where category=?");
		ps.setString(1, c);
		ResultSet rs = ps.executeQuery();
		List<ProductDto> pList = new ArrayList<ProductDto>();
		while (rs.next()) {
			pList.add(new ProductDto(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5)));
		}
		return pList;
	}

	public static ProductDto getItemWithId(int parseInt) throws ClassNotFoundException, SQLException {
		Connection con = ConnectionUtility.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from product where id=?");
		ps.setInt(1, parseInt);
		ResultSet rs=ps.executeQuery();
		ProductDto p=null;
		while(rs.next()){
			return (new ProductDto(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5)));
		}
		return null;
	}

}

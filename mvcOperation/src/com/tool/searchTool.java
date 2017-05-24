package com.tool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sitcl.mvcoperation.dao.BaseDAO;
import com.sitcl.mvcoperation.model.*;

public class searchTool {
	static Connection conn = BaseDAO.getDbConnection();

	public ArrayList<Goods> selectif(String ifif, String prices) {
		Statement stmt = null;
		ArrayList<Goods> list = null;
		
		try {
			stmt = conn.createStatement();
			
			String sql = "select *from goods where price" + ifif + " " + prices;
			ResultSet rs = null;
			rs = stmt.executeQuery(sql);
			System.out.println(rs);
			if (rs != null) {
				// 1.
				list = new ArrayList<Goods>();
				while (rs.next()) {
					// 2.
					Goods goods = new Goods();
					String goodsName = rs.getString("goodsName");
					double price = rs.getDouble("price");
					int quantity = rs.getInt("quantity");
					goods.setGoodsName(goodsName);
					goods.setPrice(price);
					goods.setQuantity(quantity);
					list.add(goods);
					// System.out.println(goodsName + "\t" + price + "\t" +
					// quantity);
					return list;
				}

				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null && !conn.isClosed())
					conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

}

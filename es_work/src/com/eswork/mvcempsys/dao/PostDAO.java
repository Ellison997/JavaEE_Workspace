package com.eswork.mvcempsys.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.eswork.mvcempsys.model.Post;

public class PostDAO {
	// 连接数据库
		Connection conn = BaseDAO.getDbConnection();

		/*
		 * 添加DAO
		 */
		public ArrayList<Post> showPost() throws SQLException {
			String sql = "select * from POST";
			// 创建Statement语句对象
			Statement stmt = null;
			ArrayList<Post> list = null;
			ResultSet rs = null;
			if (conn != null) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				list = new ArrayList<Post>();
				if (rs != null) {
					while (rs.next()) {
						Post ps = new Post();
						String postId = rs.getString("ID");
						String postName = rs.getString("NAME");
						ps.setId(postId);
						ps.setName(postName);
						list.add(ps);

					}
				}
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();

			}
			return list;
		}
}

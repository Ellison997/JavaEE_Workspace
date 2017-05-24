package com.sitcl.mvcoperation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sitcl.mvcoperation.model.Dorms;
import com.sitcl.mvcoperation.model.Manage;
import com.sitcl.mvcoperation.model.Student;

public class DormDAO {
	// 连接数据库
	Connection conn = BaseDAO.getDbConnection();

	// 查询一号楼所有宿舍
	public ArrayList<Dorms> select(int x) {
		String sql = "select * from dorm where did like '"+x+"%'";
		// 创建Statement语句对象
		Statement stmt = null;
		ArrayList<Dorms> list = null;
		ResultSet rs = null;
		if (conn != null) {
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				list = new ArrayList<Dorms>();
				if (rs != null) {
					while (rs.next()) {
						Dorms dorm = new Dorms();
						String did = rs.getString("did");
						int dbed = rs.getInt("dbed");
						int dman = rs.getInt("dman");
						String dlocation = rs.getString("dlocation");
						double dcharge = rs.getDouble("dcharge");
						String dimg = rs.getString("dimg");
						String dcollege=rs.getString("dcollege");
						dorm.setDid(did);
						dorm.setDbed(dbed);
						dorm.setDman(dman);
						dorm.setDlocation(dlocation);
						dorm.setDcharge(dcharge);
						dorm.setDimg(dimg);
						dorm.setDcollege(dcollege);
						list.add(dorm);

					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (rs != null)
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				if (stmt != null)
					try {
						stmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

			}
		}
		return list;

	}
	/*
	 * 添加DAO
	 */
	public void addDorm(Dorms dos) throws SQLException {
		if (conn != null) {
			PreparedStatement pstem = null;
			int rows = -1;

			String sql = "insert into dorm"
					+ "(did,dbed,dman,dlocation,dcollege,dcharge)"
					+ "values(?,?,?,?,?,?)";
			pstem = conn.prepareStatement(sql);
			pstem.setString(1, dos.getDid());
			pstem.setInt(2, dos.getDbed());
			pstem.setInt(3, dos.getDman());
			pstem.setString(4, dos.getDlocation());
			pstem.setString(5, dos.getDcollege());
			pstem.setDouble(6, dos.getDcharge());

			rows = pstem.executeUpdate();
			System.out.println(rows);
			if (pstem != null)
				pstem.close();

		}
	}
	

}

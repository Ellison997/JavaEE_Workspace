package com.sitcl.mvcoperation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sitcl.mvcoperation.model.Goods;

public class GoodsDAO {
	// �������ݿ�
	Connection conn = BaseDAO.getDbConnection();
	//����

	public void insert(Goods good) throws SQLException {
		if (conn != null) {
			PreparedStatement pstem = null;
			int rows = -1;

			String sql = "insert into Goods values(?,?,?)";
			pstem = conn.prepareStatement(sql);
			pstem.setString(1, good.getGoodsName());
			pstem.setDouble(2, good.getPrice());
			pstem.setInt(3, good.getQuantity());
			rows = pstem.executeUpdate();
			System.out.println(rows);
			if (pstem != null)
				pstem.close();

		}
	}
//����
	public boolean updata(Goods good) throws SQLException {
		if (conn != null) {
			PreparedStatement pstmt = null;
			String sql = "UPDATE goods SET price =?,quantity=? WHERE goodsName =?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setDouble(1, good.getPrice());
			pstmt.setInt(2, good.getQuantity());
			pstmt.setString(3, good.getGoodsName());
			pstmt.executeUpdate();

			if (pstmt != null)
				pstmt.close();
			return true;
		}
		return false;
	}

	// ��ѯ���е���Ϣ
	//��ѯ
	public ArrayList<Goods> selectAll() {
		String sql = "select * from goods";
		// ����Statement������
		Statement stmt = null;
		ArrayList<Goods> list = null;
		ResultSet rs = null;
		if (conn != null) {
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				list = new ArrayList<Goods>();
				if (rs != null) {
					while (rs.next()) {

						Goods goods = new Goods();
						String goodsName = rs.getString("goodsName");
						double price = rs.getDouble("price");
						int quantity = rs.getInt("quantity");
						goods.setGoodsName(goodsName);
						goods.setPrice(price);
						goods.setQuantity(quantity);
						list.add(goods);
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
//ɾ��
	public boolean delete(String name) throws SQLException {
		if (conn != null) {
			PreparedStatement pstmt = null;
			String sql = "DELETE FROM goods WHERE goodsName =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			int rs = pstmt.executeUpdate();
			if (pstmt != null) {
				pstmt.close();
			}
			return true;
		}
		return false;
	}
}

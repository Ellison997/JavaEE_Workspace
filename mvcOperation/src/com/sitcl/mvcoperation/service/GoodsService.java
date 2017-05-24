package com.sitcl.mvcoperation.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sitcl.mvcoperation.dao.GoodsDAO;
import com.sitcl.mvcoperation.model.Goods;

public class GoodsService {
	/**
	 * 添加功能
	 */
	GoodsDAO gdao = new GoodsDAO();

	public boolean addGoods(Goods good) {
		try {
			gdao.insert(good);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		

	}

	public boolean updateGoods(Goods good) {
		boolean ifupd = false;
		try {
			ifupd = gdao.updata(good);
			System.out.println("修改成功！");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ifupd;

	}
	public boolean deleteGoogs(String name){
		boolean ifdel = false;
		try {
			ifdel = gdao.delete(name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ifdel;
		
	}
	public ArrayList<Goods> selectGoods(){
		GoodsDAO gdao=new GoodsDAO();
		ArrayList<Goods> list=gdao.selectAll();
		
		return list;
		
	}

}

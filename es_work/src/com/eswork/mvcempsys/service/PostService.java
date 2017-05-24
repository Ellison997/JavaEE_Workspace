package com.eswork.mvcempsys.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.eswork.mvcempsys.dao.PostDAO;
import com.eswork.mvcempsys.model.Post;

public class PostService {

	PostDAO psDao=new PostDAO();
	public ArrayList<Post> getPost() throws SQLException{
		ArrayList<Post> list=null;
		list=psDao.showPost();
		return list;
	}
}

package com.sitcl.mvcoperation.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sitcl.mvcoperation.dao.GoodsDAO;
import com.sitcl.mvcoperation.model.Goods;
import com.sitcl.mvcoperation.service.GoodsService;

public class DoUpdate extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DoUpdate() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		String gname = request.getParameter("goodsname");
		String prices = request.getParameter("price");
		String quantitys = request.getParameter("quantity");
		double price = 0;
		if (prices != null && !prices.equals("")) {
			price = Double.parseDouble(prices);
		}
		int quantity = 0;
		if (quantitys != null && !quantitys.equals("")) {
			quantity = Integer.parseInt(quantitys);
		}
		Goods gs = new Goods();
		gs.setGoodsName(gname);
		gs.setPrice(price);
		gs.setQuantity(quantity);
		GoodsService gService = new GoodsService();
		boolean isb = gService.updateGoods(gs);
		if (isb) {
			response.sendRedirect("index.jsp");
			System.out.print("修改成功！");
		} else {
			System.out.print("修改失败！");
			response.sendRedirect("Update.jsp");
		}

	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}

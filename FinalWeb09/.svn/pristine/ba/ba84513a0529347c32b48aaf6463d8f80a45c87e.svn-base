package com.ttjv.controller.client.billproduct;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ttjv.dao.BillProductDao;
import com.ttjv.impl.BillProductDaoImpl;
import com.ttjv.model.BillProduct;
@WebServlet(urlPatterns="/billproduct/search")
public class BillProductSearch extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String findName=req.getParameter("name");
		if(findName==null) {
			findName="";
		}
		BillProductDao billProductDao= new BillProductDaoImpl();
		List<BillProduct> listBillProduct =billProductDao.search(findName);
		req.setAttribute("listBillProduct", listBillProduct);
		RequestDispatcher dispatcher
		= req.getRequestDispatcher("/billproduct/view/billproduct/search.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

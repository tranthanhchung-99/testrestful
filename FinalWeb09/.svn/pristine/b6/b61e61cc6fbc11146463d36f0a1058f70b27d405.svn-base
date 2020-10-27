package com.ttjv.controller.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ttjv.dao.ProductDao;
import com.ttjv.impl.ProductDaoImpl;
import com.ttjv.model.Product;
@WebServlet(urlPatterns="/client/product")
public class ClientProduct extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String findName= req.getParameter("name");
		if(findName==null) {
			findName="";
		}
		ProductDao productDao= new ProductDaoImpl();
		List<Product> list= productDao.search(findName);
		req.setAttribute("productList", list);
		RequestDispatcher requestDispatcher= req.getRequestDispatcher("/client/view/product/menu.jsp");
		requestDispatcher.forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

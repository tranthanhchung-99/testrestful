package com.ttjv.controller.client;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ttjv.dao.ProductDao;
import com.ttjv.impl.ProductDaoImpl;
import com.ttjv.model.Product;
@WebServlet(urlPatterns="/client/1product")
public class Client1Product extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id =req.getParameter("id");
		ProductDao productDao= new ProductDaoImpl();
		Product product=  productDao.get(Integer.parseInt(id));
		req.setAttribute("product", product);
		
		RequestDispatcher dispatcher= req.getRequestDispatcher("/client/view/product/infor1product.jsp");
		dispatcher.forward(req, resp);
	}
}

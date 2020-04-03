package com.ttjv.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ttjv.dao.ProductDao;
import com.ttjv.impl.ProductDaoImpl;
@WebServlet(urlPatterns="/admin/product/delete")
public class AdminProductDelete extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		ProductDao productDao= new ProductDaoImpl();
		productDao.delete(Integer.parseInt(id));
		
		resp.sendRedirect(req.getContextPath()+"/admin/product/search");
	}
}

package com.ttjv.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ttjv.dao.CategoryDao;
import com.ttjv.impl.CategoryDaoImpl;
import com.ttjv.model.Category;
@WebServlet(urlPatterns="/admin/category/search")
public class AdminCategorySearch extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String findName= req.getParameter("name");
		if(findName==null) {findName="";}
		CategoryDao categoryDao= new CategoryDaoImpl();
		List<Category> list = categoryDao.search(findName);
		
		req.setAttribute("listCategory", list);
		
		RequestDispatcher requestDispatcher= req.getRequestDispatcher("/admins/view/category/search.jsp");
		requestDispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

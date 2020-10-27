package com.ttjv.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ttjv.dao.CategoryDao;
import com.ttjv.impl.CategoryDaoImpl;
import com.ttjv.model.Category;
@WebServlet(urlPatterns="/admin/category/add")
public class AdminCategoryAdd extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher= req.getRequestDispatcher("/admins/view/category/add.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		Category category= new Category();
		category.setName(name);
		CategoryDao categoryDao= new CategoryDaoImpl();
		categoryDao.insert(category);
		resp.sendRedirect(req.getContextPath()+"/admin/category/search");
	}
}

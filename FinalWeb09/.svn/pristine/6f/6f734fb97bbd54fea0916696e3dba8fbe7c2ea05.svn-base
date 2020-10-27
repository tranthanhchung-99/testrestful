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
@WebServlet(urlPatterns="/admin/category/delete")
public class AdminCategoryDelete extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		CategoryDao categoryDao= new CategoryDaoImpl();
		categoryDao.delete(Integer.parseInt(id));
		resp.sendRedirect(req.getContextPath()+"/admin/category/search");
	}
}

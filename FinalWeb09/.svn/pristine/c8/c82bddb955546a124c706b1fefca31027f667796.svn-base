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

@WebServlet(urlPatterns = "/admin/category/update")
public class AdminCategoryUpdate extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		CategoryDao categoryDao = new CategoryDaoImpl();
		Category category = categoryDao.get(Integer.parseInt(id));
		req.setAttribute("category", category);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admins/view/category/update.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		Category category = new Category();
		category.setId(Integer.parseInt(id));
		category.setName(name);
		CategoryDao categoryDao = new CategoryDaoImpl();
		categoryDao.update(category);
		resp.sendRedirect(req.getContextPath() + "/admin/category/search");
	}
}

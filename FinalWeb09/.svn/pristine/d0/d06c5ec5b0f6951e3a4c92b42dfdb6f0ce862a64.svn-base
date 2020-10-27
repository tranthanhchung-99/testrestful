package com.ttjv.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ttjv.dao.UserDao;
import com.ttjv.impl.UserDaoImpl;
import com.ttjv.model.User;

@WebServlet(urlPatterns = "/admin/infor")
public class AdminInfor extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		UserDao dao = new UserDaoImpl();
		User user = dao.get(id);
		req.setAttribute("user", user);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admins/view/infor.jsp");
		dispatcher.forward(req, resp);
	}
}

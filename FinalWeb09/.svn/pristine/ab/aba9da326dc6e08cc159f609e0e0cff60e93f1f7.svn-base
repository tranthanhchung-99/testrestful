package com.ttjv.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ttjv.dao.UserDao;
import com.ttjv.impl.UserDaoImpl;
import com.ttjv.model.User;
@WebServlet(urlPatterns="/admin/user/update")
public class AdminUserUpdate extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id= req.getParameter("id");
		UserDao dao= new UserDaoImpl();
		User user= dao.get(id);
		req.setAttribute("user", user);
		RequestDispatcher requestDispatcher= req.getRequestDispatcher("/admins/view/user/update.jsp");
		requestDispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user =new User();
		user.setName(req.getParameter("name"));
		user.setAge(req.getParameter("age"));
		user.setRole(req.getParameter("role"));
		user.setImageUrl(req.getParameter("imageUrl"));
		user.setUserName(req.getParameter("userName"));
		user.setMatKhau(req.getParameter("matKhau"));
		user.setGender(req.getParameter("gender"));
		user.setAddress(req.getParameter("address"));
		user.setId(req.getParameter("id"));
		UserDao dao= new UserDaoImpl();
		dao.update(user);
		resp.sendRedirect(req.getContextPath()+"/admin/user/search");
	}
}

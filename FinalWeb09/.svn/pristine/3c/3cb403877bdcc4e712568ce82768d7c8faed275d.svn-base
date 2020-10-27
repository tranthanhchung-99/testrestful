package com.ttjv.controller.client;

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

@WebServlet(urlPatterns = "/dangki")
public class ClientDangKi extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/clients/view/dangki.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = new User();
		user.setName(req.getParameter("name"));
		user.setAge(req.getParameter("date"));
		user.setRole(req.getParameter("role"));
		user.setUserName(req.getParameter("userName"));
		user.setMatKhau(req.getParameter("passWord"));
		user.setGender(req.getParameter("gender"));
		user.setAddress(req.getParameter("address"));
		user.setImageUrl("image");
		UserDao dao = new UserDaoImpl();
		dao.insert(user);
		resp.sendRedirect(req.getContextPath() + "/dang-ki-thanh-cong");
	}
}

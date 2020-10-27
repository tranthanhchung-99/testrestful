package com.ttjv.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ttjv.dao.UserDao;
import com.ttjv.impl.UserDaoImpl;
import com.ttjv.model.User;

@WebServlet(urlPatterns = "/admin/user/search")
public class AdminUserSearch extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * HttpSession httpSession= req.getSession();
		 * if(httpSession.getAttribute("loginUser") !=null) { User users= (User)
		 * httpSession.getAttribute("loginUser");
		 * System.out.println("login "+users.getName());
		 * System.out.println(httpSession.getId()); }
		 */

		String findName = req.getParameter("name");
		if (findName == null) {
			findName = "";
		}
		UserDao dao = new UserDaoImpl();
		List<User> list = dao.search(findName);
		req.setAttribute("userlist", list);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/admins/view/user/search.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

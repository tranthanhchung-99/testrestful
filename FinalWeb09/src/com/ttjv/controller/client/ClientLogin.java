package com.ttjv.controller.client;

import java.io.IOException;

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

@WebServlet(urlPatterns = "/login-client")
public class ClientLogin extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String err = req.getParameter("err");
		if (err != null) {
			req.setAttribute("errMsg", "thong tin mk or tk sai");
		}
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/clients/view/login.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("userName");
		String matkhau = req.getParameter("matKhau");
		UserDao dao = new UserDaoImpl();
		User user = dao.getByUserName(username);
		if (username != null && user.getMatKhau().equals(matkhau)) {
			System.out.println("dn thanh cong");
			HttpSession httpSession = req.getSession();
			httpSession.setAttribute("loginClient", user);
			resp.sendRedirect("/FinalWeb09/client/product");
		} else {
			System.out.println("dn that bai");
			resp.sendRedirect("/FinalWeb09/login-client?err=1");
		}
	}
}

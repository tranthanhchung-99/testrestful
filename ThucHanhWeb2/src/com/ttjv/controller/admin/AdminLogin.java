package com.ttjv.controller.admin;

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
@WebServlet(urlPatterns="/login-admin")
public class AdminLogin extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String err= req.getParameter("err");
		if(err!=null) {req.setAttribute("errMsg", "thong tin tai khoan or mat khau k chinh xac (^.^)");}
		
		
		RequestDispatcher requestDispatcher= req.getRequestDispatcher("/admins/view/login.jsp");
		requestDispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("userName");
		//System.out.println(username);
		String matkhau= req.getParameter("matKhau");
		//System.out.println(matkhau);
		UserDao dao= new UserDaoImpl();
		User user= dao.getByUserName(username);
		//System.out.println(user.getName());
		if(username!=null&& user.getMatKhau().equals(matkhau)) {
			System.out.println("dn thanh cong");
			HttpSession httpSession=req.getSession();
			httpSession.setAttribute("loginUser", user);
			resp.sendRedirect("/FinalWeb09/admin/dashboach");
		}else {
			System.out.println("dn that bai");
			resp.sendRedirect("/FinalWeb09/login-admin?err=1");
		}
	}
}

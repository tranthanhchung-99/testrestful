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
@WebServlet(urlPatterns="/client/inforclient")
public class ClientInfor extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id= req.getParameter("id");
		UserDao dao= new UserDaoImpl();
		User user= dao.get(id);
		req.setAttribute("user", user);
		RequestDispatcher dispatcher= req.getRequestDispatcher("/client/view/inforclient.jsp");
		dispatcher.forward(req, resp);
		
	}
	
}

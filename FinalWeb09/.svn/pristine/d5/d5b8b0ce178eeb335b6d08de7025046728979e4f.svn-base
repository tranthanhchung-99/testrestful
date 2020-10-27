package com.ttjv.controller.client;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.ttjv.dao.UserDao;
import com.ttjv.impl.UserDaoImpl;
import com.ttjv.model.User;

@WebServlet(urlPatterns = "/client/updatepass")
public class UpdatePass extends HttpServlet {
	private String pass = "";
	private String pid = "";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		UserDao dao = new UserDaoImpl();
		User user = dao.get(id);
		pid = user.getId();
		pass = user.getMatKhau();
		req.setAttribute("user", user);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/clients/view/updatepass.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDao dao = new UserDaoImpl();
		User user = new User();
		String oldpass = req.getParameter("oldmatKhau");
		if (oldpass.equals(pass)) {
			user.setMatKhau(req.getParameter("newmatKhau"));
			user.setId(pid);
			dao.updatePass(user);
			resp.sendRedirect(req.getContextPath() + "/login-client");
		} else {
			resp.sendRedirect(req.getContextPath() + "/client/updatepass?id" + pid);
		}
	}
}

package com.ttjv.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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

@WebServlet(urlPatterns = "/admin/user/update")
public class AdminUserUpdate extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		UserDao dao = new UserDaoImpl();
		User user = dao.get(id);
		req.setAttribute("user", user);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admins/view/user/update.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			User user = new User();
			DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
			diskFileItemFactory.setRepository(new File("C:\\filetest"));
			ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
			List<FileItem> list = fileUpload.parseRequest(req);
			for (FileItem item : list) {
				if (item.getFieldName().equals("name")) {
					String name = item.getString();
					user.setName(name);
				}
				if (item.getFieldName().equals("age")) {
					String age = item.getString();
					user.setAge(age);
				}
				if (item.getFieldName().equals("role")) {
					String role = item.getString();
					user.setRole(role);
				}
				if (item.getFieldName().equals("imageFile")) {
					if (item.getSize() > 0) {
						final String fodername = "C:\\filetest";
						String filename = item.getName();
						int index = filename.lastIndexOf(".");
						String duoi = filename.substring(index);

						String image = System.currentTimeMillis() + duoi;
						File file = new File(fodername + File.separator + image);
						item.write(file);
						user.setImageUrl(image);
					}
				}
				if (item.getFieldName().equals("userName")) {
					String username = item.getString();
					user.setUserName(username);
				}
				if (item.getFieldName().equals("matKhau")) {
					String pass = item.getString();
					user.setMatKhau(pass);
				}
				if (item.getFieldName().equals("gender")) {
					String gender = item.getString();
					user.setGender(gender);
				}
				if (item.getFieldName().equals("address")) {
					String address = item.getString();
					user.setAddress(address);
				}
				if (item.getFieldName().equals("id")) {
					String id = item.getString();
					user.setId(id);
				}
			}
			UserDao dao = new UserDaoImpl();
			dao.update(user);
			resp.sendRedirect(req.getContextPath() + "/admin/user/search");
		} catch (Exception e) {
			System.out.println("loi>>" + e.getMessage());
		}

	}
}

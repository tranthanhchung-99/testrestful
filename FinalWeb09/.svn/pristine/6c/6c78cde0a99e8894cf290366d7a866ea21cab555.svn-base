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

@WebServlet(urlPatterns = "/admin/user/add")
public class AdminUserAdd extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admins/view/user/add.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			UserDao dao = new UserDaoImpl();
			User user = new User();
			DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
			diskFileItemFactory.setRepository(new File("C:\\filetest"));
			ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
			List<FileItem> list = fileUpload.parseRequest(req);
			for (FileItem item : list) {
				System.out.println(1);
				if (item.getFieldName().equals("name")) {
					String name = item.getString();
					user.setName(name);
				}
				System.out.println(2);
				if (item.getFieldName().equals("age")) {
					String age = item.getString();
					user.setAge(age);
				}
				System.out.println(3);
				if (item.getFieldName().equals("role")) {
					String role = item.getString();
					user.setRole(role);
				}
				System.out.println(4);
				if (item.getFieldName().equals("imageFile")) {
					if (item.getSize() > 0) {
						final String foderUpload = "C:\\filetest";
						String fileName = item.getName();
						int index = fileName.lastIndexOf(".");
						String duoi = fileName.substring(index);

						String image = System.currentTimeMillis() + duoi;
						File file = new File(foderUpload + File.separator + image);
						item.write(file);
						user.setImageUrl(image);
					}
				}
				System.out.println(5);
				if (item.getFieldName().equals("userName")) {
					String username = item.getString();
					user.setUserName(username);
				}
				System.out.println(6);
				if (item.getFieldName().equals("matKhau")) {
					String matKhau = item.getString();
					user.setMatKhau(matKhau);
				}
				System.out.println(7);
				if (item.getFieldName().equals("gender")) {
					String gender = item.getString();
					user.setGender(gender);
				}
				System.out.println(8);
				if (item.getFieldName().equals("address")) {
					String address = item.getString();
					user.setAddress(address);
				}
				System.out.println(9);
			}
			dao.insert(user);
			resp.sendRedirect(req.getContextPath() + "/admin/user/search");
		} catch (Exception e) {
			System.out.println("loi>>" + e.getMessage());
		}

	}
}

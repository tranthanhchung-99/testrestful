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

import com.ttjv.dao.ProductDao;
import com.ttjv.impl.ProductDaoImpl;
import com.ttjv.model.Category;
import com.ttjv.model.Product;

@WebServlet(urlPatterns = "/admin/product/update")
public class AdminProductUpdate extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");

		ProductDao productDao = new ProductDaoImpl();
		Product product = productDao.get(Integer.parseInt(id));

		req.setAttribute("product", product);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admins/view/product/update.jsp");
		requestDispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Product product = new Product();
			DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory(); // tao doi tuong luu tam thoi file
																					// upload vao o dia
			diskFileItemFactory.setRepository(new File("C:\\filetest"));// kich thuoc lon hon mac dinh
			ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
			List<FileItem> list = fileUpload.parseRequest(req);
			for (FileItem fileItem : list) {
				System.out.println(1);
				if (fileItem.getFieldName().equals("id")) {
					String id = fileItem.getString();
					product.setId(Integer.parseInt(id));
				}
				System.out.println(2);
				if (fileItem.getFieldName().equals("name")) {
					String name = fileItem.getString();
					product.setName(name);

				}
				System.out.println(3);
				if (fileItem.getFieldName().equals("price")) {
					String price = fileItem.getString();
					product.setPrice(Integer.parseInt(price));
				}
				System.out.println(4);
				if (fileItem.getFieldName().equals("description")) {
					String description = fileItem.getString();
					product.setDescription(description);
				}

				System.out.println(5);
				if (fileItem.getFieldName().equals("idCategory")) {
					String idCategory = fileItem.getString();
					Category category = new Category();
					category.setId(Integer.parseInt(idCategory));
					product.setCategory(category);
				}
				System.out.println(6);
				if (fileItem.getFieldName().equals("imageFile")) {
					if (fileItem.getSize() > 0) {
						final String upFile = "C:\\filetest";// tao 1 thu muc cha de luu file tren server
						String name = fileItem.getName();
						// tim dang cua file
						int n = name.lastIndexOf(".");
						String duoi = name.substring(n);
						String image = System.currentTimeMillis() + duoi;// tao ten moi cho anh voi duoi mo rong nhu
																			// file upload luc truoc
						File file = new File(upFile + File.separator + image);// tao thu muc con de luu anh voi ten
																				// moi vao trong thu muc cha
						// ghi du lieu upload len vao file
						fileItem.write(file);
						product.setImage(image);
					}

				}
				System.out.println(7);
			}
			ProductDao productDao = new ProductDaoImpl();
			productDao.update(product);
			resp.sendRedirect(req.getContextPath() + "/admin/product/search");
		} catch (Exception exception) {
			System.out.println("loi>>" + exception.getMessage());
		}

	}
}

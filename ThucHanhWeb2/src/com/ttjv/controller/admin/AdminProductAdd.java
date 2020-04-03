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
@WebServlet(urlPatterns="/admin/product/add")
public class AdminProductAdd extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher requestDispatcher= req.getRequestDispatcher("/admins/view/product/add.jsp");
		requestDispatcher.forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {Product product= new Product();
			DiskFileItemFactory diskFileItemFactory=new DiskFileItemFactory();// cho phep lay noi dung tu pc
			diskFileItemFactory.setRepository(new File("C:\\filetest"));// luu tam noi dung vao o ddia voi ung luong lon hon mac dinh 10kb
			ServletFileUpload fileUpload=new ServletFileUpload(diskFileItemFactory);//cho pheps tai file len 
			List<FileItem> fieldList=fileUpload.parseRequest(req);
			for(FileItem item:fieldList) {
				System.out.println(1);
				if(item.getFieldName().equals("name")) {
					String name=item.getString();
					product.setName(name);
					
				}
				System.out.println(2);
				if(item.getFieldName().equals("price")) {
					String price=item.getString();
					product.setPrice(Integer.parseInt(price));
					
				}
				System.out.println(3);
				if(item.getFieldName().equals("imageFile")) {
					if(item.getSize()>0) {//kieem tra xem co up anh hay k??
						final String uploadFolder="C:\\filetest";
						String fileName=item.getName();
						int index=fileName.lastIndexOf(".");
						String ext= fileName.substring(index);
						
						String image=System.currentTimeMillis()+ext;
						File file= new File(uploadFolder+File.separator+image);
						item.write(file);
						product.setImage(image);
					}
					
				}
				System.out.println(4);
				if(item.getFieldName().equals("description")) {
					String description=item.getString();
					product.setDescription(description);
					
				}
				System.out.println(5);
				if(item.getFieldName().equals("idCategory")) {
					String idcate=item.getString();
					Category category= new Category();
					category.setId(Integer.parseInt(idcate)) ;
					product.setCategory(category);
					
				}
				System.out.println(6);
				
			}
			ProductDao productDao= new ProductDaoImpl();
			productDao.insert(product);
			resp.sendRedirect(req.getContextPath()+"/admin/product/search");
		}catch(Exception exception) {
			System.out.println("loi"+exception.getMessage());
		}
	}
}

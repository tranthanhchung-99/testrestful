package com.ttjv.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ttjv.dao.CategoryDao;
import com.ttjv.impl.CategoryDaoImpl;
import com.ttjv.model.Category;

@WebServlet(urlPatterns = "/admin/category/search")
public class AdminCategorySearch extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//doc len keyword
				String keyword = req.getParameter("keyword");
				
				//truong hop keyword = null (vi du lan dau vao trang search)
				if (keyword == null) {
					keyword = "";
				}
				
				// day qua view de sử dụng cho v� o form search giữ lại giá trị cho các lần search sau cho phân trang
				req.setAttribute("keyword", keyword);

				int pageNo = 1;// mac dinh page dau tien
				
				//doc len so trang
				String pageNoStr = req.getParameter("pageNo");
				// neu co truyen len so trang
				if (pageNoStr != null) {
					pageNo = Integer.parseInt(pageNoStr);
				}
				
				//code phan trang
				CategoryDao categoryDao = new CategoryDaoImpl();

				/// PHAN TRANG
				// MAC DINH
				final int maxPerPage = 5;// FiX Cung
				
				// tinh tong so trang
				int total = categoryDao.count("");
				int maxPage = (int) Math.ceil(total / (double) maxPerPage);
				int startFromRecord = (pageNo - 1) * maxPerPage;

				// day qua view de for
				req.setAttribute("maxPage", maxPage);

				List<Category> categoryList = categoryDao.search(keyword, startFromRecord, maxPerPage);//thay cac bien vao day
				req.setAttribute("categoryList", categoryList);

				RequestDispatcher dispatcher = req.getRequestDispatcher("/admins/view/category/search.jsp");
				dispatcher.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

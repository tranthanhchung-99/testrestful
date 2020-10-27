package com.ttjv.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ttjv.dao.BillProductDao;
import com.ttjv.impl.BillProductDaoImpl;
import com.ttjv.model.BillProduct;

@WebServlet(urlPatterns = "/admin/billproduct/search")
public class AdminBillProductSearch extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String findName = req.getParameter("idBill");

		BillProductDao billProductDao = new BillProductDaoImpl();
		List<BillProduct> listBillProduct = billProductDao.searchtheoidbill(Integer.parseInt(findName));
		req.setAttribute("listBillProduct", listBillProduct);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admins/view/billproduct/search.jsp");
		dispatcher.forward(req, resp);
	}
}

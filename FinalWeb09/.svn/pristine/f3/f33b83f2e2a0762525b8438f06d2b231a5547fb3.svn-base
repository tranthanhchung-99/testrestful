package com.ttjv.controller.client.billproduct;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ttjv.dao.BillProductDao;
import com.ttjv.impl.BillProductDaoImpl;
import com.ttjv.model.Bill;
import com.ttjv.model.BillProduct;
import com.ttjv.model.Product;

@WebServlet(urlPatterns = "/billproduct/update")
public class BillProductUpdate extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		BillProductDao billProductDao = new BillProductDaoImpl();
		BillProduct billProduct = billProductDao.get(id);
		req.setAttribute("billProduct", billProduct);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/billproduct/view/billproduct/update.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BillProduct billProduct = new BillProduct();
		billProduct.setId(Integer.parseInt(req.getParameter("id")));
		billProduct.setQuantity(Integer.parseInt(req.getParameter("quantity")));
		billProduct.setUnitPrice(Long.parseLong(req.getParameter("unitPrice")));
		Bill bill = new Bill();
		bill.setId(Integer.parseInt(req.getParameter("idBill")));
		Product product = new Product();
		product.setId(Integer.parseInt(req.getParameter("idProduct")));
		billProduct.setProduct(product);
		billProduct.setBill(bill);
		BillProductDao billProductDao = new BillProductDaoImpl();
		billProductDao.update(billProduct);
		resp.sendRedirect(req.getContextPath() + "/billproduct/search");
	}
}

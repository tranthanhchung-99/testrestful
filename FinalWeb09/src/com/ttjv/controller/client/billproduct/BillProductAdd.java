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
import com.ttjv.model.User;

@WebServlet(urlPatterns = "/billproduct/add")
public class BillProductAdd extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/billproduct/view/billproduct/add.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BillProductDao billProductDao = new BillProductDaoImpl();
		BillProduct billProduct = new BillProduct();
		billProduct.setQuantity(Integer.parseInt(req.getParameter("quantity")));
		billProduct.setUnitPrice(Long.parseLong(req.getParameter("unitPrice")));
		Bill bill = new Bill();
		bill.setId(Integer.parseInt(req.getParameter("idBill")));
		Product product = new Product();
		product.setId(Integer.parseInt(req.getParameter("idProduct")));
		billProduct.setBill(bill);
		billProduct.setProduct(product);
		billProductDao.insert(billProduct);
		resp.sendRedirect(req.getContextPath() + "/billproduct/search");
	}
}

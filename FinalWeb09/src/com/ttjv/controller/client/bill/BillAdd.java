package com.ttjv.controller.client.bill;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ttjv.dao.BillDao;
import com.ttjv.impl.BillDaoImpl;
import com.ttjv.model.Bill;
import com.ttjv.model.User;

@WebServlet(urlPatterns = "/bill/add")
public class BillAdd extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/bill/view/bill/add.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = new User();
		user.setId(req.getParameter("idUser"));
		Bill bill = new Bill();
		bill.setUser(user);
		bill.setBuyDate(req.getParameter("buyDate"));
		bill.setPriceTotal(Long.parseLong(req.getParameter("priceTotal")));
		BillDao billDao = new BillDaoImpl();
		billDao.insert(bill);
		resp.sendRedirect(req.getContextPath() + "/bill/search");
	}
}

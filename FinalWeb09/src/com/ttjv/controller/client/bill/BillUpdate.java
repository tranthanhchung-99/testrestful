package com.ttjv.controller.client.bill;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.corba.se.impl.ior.NewObjectKeyTemplateBase;
import com.ttjv.dao.BillDao;
import com.ttjv.impl.BillDaoImpl;
import com.ttjv.model.Bill;
import com.ttjv.model.User;

@WebServlet(urlPatterns = "/bill/update")
public class BillUpdate extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		BillDao billDao = new BillDaoImpl();
		Bill bill = billDao.get(id);
		req.setAttribute("bill", bill);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/bill/view/bill/update.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Bill bill = new Bill();
		bill.setId(Integer.parseInt(req.getParameter("id")));
		bill.setBuyDate(req.getParameter("buyDate"));
		bill.setPriceTotal(Long.parseLong(req.getParameter("priceTotal")));
		User user = new User();
		user.setId(req.getParameter("idUser"));
		bill.setUser(user);
		BillDao billDao = new BillDaoImpl();
		billDao.update(bill);
		resp.sendRedirect(req.getContextPath() + "/bill/search");
	}
}

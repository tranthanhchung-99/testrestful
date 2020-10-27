package com.ttjv.controller.client.bill;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ttjv.dao.BillDao;
import com.ttjv.impl.BillDaoImpl;
import com.ttjv.model.Bill;
import com.ttjv.model.User;

@WebServlet(urlPatterns = "/bill/search")
public class BillSearch extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("loginClient");
		BillDao billDao = new BillDaoImpl();
		List<Bill> listBill = billDao.search(user.getName());
		req.setAttribute("listBill", listBill);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/clients/view/bill/search.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

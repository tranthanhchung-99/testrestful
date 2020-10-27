package com.ttjv.controller.admin;

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

@WebServlet(urlPatterns = "/admin/bill/search")
public class AdminBillSearch extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String findName = req.getParameter("name");
		if (findName == null) {
			findName = "";
		}

		BillDao billDao = new BillDaoImpl();
		List<Bill> listBill = billDao.search(findName);
		req.setAttribute("listBill", listBill);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admins/view/bill/search.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

package com.ttjv.controller.client;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ttjv.dao.BillDao;
import com.ttjv.dao.BillProductDao;
import com.ttjv.impl.BillDaoImpl;
import com.ttjv.impl.BillProductDaoImpl;
import com.ttjv.model.Bill;
import com.ttjv.model.BillProduct;
import com.ttjv.model.User;
@WebServlet(urlPatterns="/client/bill/add")
public class ClientAddBill extends HttpServlet{
	BillDao billDao= new BillDaoImpl();
	BillProductDao billProductDao= new BillProductDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session= req.getSession();
		Object object=session.getAttribute("cart");
		if(object!=null) {
			Map<String , BillProduct> map=(Map<String, BillProduct>) object;
			Bill bill= new Bill();
			SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
			bill.setBuyDate(dateFormat.format(new Date()));
			User user= (User) session.getAttribute("loginClient");
			bill.setUser(user);
			billDao.insert(bill);
			
			long totalPrice=0;
			for(Entry<String, BillProduct> entry:map.entrySet()) {
				BillProduct billProduct=entry.getValue();
				
				billProduct.setBill(bill);
				
				billProductDao.insert(billProduct);
				totalPrice= totalPrice+(billProduct.getQuantity()*billProduct.getUnitPrice());
			}
			System.out.println(totalPrice);
			bill.setPriceTotal(totalPrice);
			billDao.update(bill);
			session.removeAttribute("cart");
			resp.sendRedirect(req.getContextPath()+"/bill/search");
			
		}else {
			resp.sendRedirect(req.getContextPath()+"/client/product");
		}
	}
}

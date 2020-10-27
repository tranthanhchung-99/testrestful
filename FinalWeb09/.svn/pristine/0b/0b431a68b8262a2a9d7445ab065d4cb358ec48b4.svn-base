package com.ttjv.controller.client;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ttjv.model.BillProduct;
@WebServlet(urlPatterns="/delete-from-cart")
public class ClientDeleteFromCart extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String key=req.getParameter("key");
		HttpSession session= req.getSession();
		Object object=session.getAttribute("cart");
		if(object!=null) {
			Map<String, BillProduct> map= (Map<String, BillProduct>) object;
			map.remove(key);
			session.setAttribute("cart", map);
		}
		resp.sendRedirect(req.getContextPath()+"/cart");
	}
	
}

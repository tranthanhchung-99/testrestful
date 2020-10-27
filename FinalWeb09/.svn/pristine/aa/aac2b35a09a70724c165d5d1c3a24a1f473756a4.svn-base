package com.ttjv.controller.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ttjv.model.BillProduct;

@WebServlet(urlPatterns="/cart")
public class ClientCart extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*HttpSession session=req.getSession();
		Object object=session.getAttribute("cart");
		
		List<BillProduct> listproduct= new ArrayList<BillProduct>();
		if(object!=null) {
			Map<String, BillProduct> map= (Map<String, BillProduct>) object;
			
		}*/
		
		RequestDispatcher requestDispatcher= req.getRequestDispatcher("/client/view/cart/listcart.jsp");
		requestDispatcher.forward(req, resp);
	}
}

package com.ttjv.controller.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.corba.se.impl.ior.NewObjectKeyTemplateBase;
import com.ttjv.dao.BillProductDao;
import com.ttjv.dao.ProductDao;
import com.ttjv.impl.BillProductDaoImpl;
import com.ttjv.impl.ProductDaoImpl;
import com.ttjv.model.BillProduct;
import com.ttjv.model.Product;

@WebServlet(urlPatterns="/add-to-cart")//? product id
public class ClientAddToCart extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pId=req.getParameter("pid");
		ProductDao productDao= new ProductDaoImpl();
		Product product=  productDao.get(Integer.parseInt(pId));
		BillProduct billProduct= new BillProduct();
		HttpSession session= req.getSession();
		Object object= session.getAttribute("cart");
		if(object==null){
			
			billProduct= new BillProduct();
			billProduct.setProduct(product);
			billProduct.setQuantity(1);
			billProduct.setUnitPrice(product.getPrice());
			Map<String, BillProduct> map= new HashMap<>();
			map.put(pId, billProduct);
			session.setAttribute("cart", map);
		}else {
			Map<String, BillProduct> map=(Map<String, BillProduct>) object;
			billProduct=map.get(pId);
			if(billProduct==null) {
				billProduct= new BillProduct();
				billProduct.setProduct(product);
				billProduct.setQuantity(1);
				billProduct.setUnitPrice(product.getPrice());
				map.put(pId, billProduct);
			}else {
				billProduct.setQuantity(billProduct.getQuantity()+1);
				
			}
			session.setAttribute("cart", map);
			
		}
		
		
		
	
		
		resp.sendRedirect(req.getContextPath()+"/cart");
	}
}

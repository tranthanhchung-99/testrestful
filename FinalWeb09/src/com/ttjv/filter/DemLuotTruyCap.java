package com.ttjv.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.ttjv.dao.LuotTruyCapDao;
import com.ttjv.impl.LuotTruyCapDaoImpl;
import com.ttjv.model.LuotTruyCap;

@WebFilter(urlPatterns = "/client/product")
public class DemLuotTruyCap implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {

		LuotTruyCapDao capDao = new LuotTruyCapDaoImpl();
		LuotTruyCap cap = capDao.search();
		int n = Integer.parseInt(cap.getSoLuot());
		int x = 1 + n;
		LuotTruyCap luotTruyCap = new LuotTruyCap();
		luotTruyCap.setSoLuot(String.valueOf(x));
		LuotTruyCapDao capDao1 = new LuotTruyCapDaoImpl();
		capDao1.update(luotTruyCap);
		LuotTruyCap cap2 = capDao1.search();
		System.out.println("so luot truy cap:" + cap2.getSoLuot());
		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}

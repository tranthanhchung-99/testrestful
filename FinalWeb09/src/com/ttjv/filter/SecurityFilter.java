package com.ttjv.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ttjv.model.User;

@WebFilter(urlPatterns = { "/admin/*" })
public class SecurityFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		HttpSession session = request.getSession();
		if (session.getAttribute("loginUser") != null) {
			User user = (User) session.getAttribute("loginUser");
			// System.out.println(user.getName());
			if (user.getRole().equals("admin")) {
				arg2.doFilter(request, response);
			} else {
				response.sendRedirect("/FinalWeb09/err");
			}
			// arg2.doFilter(request, response);
		} else {
			response.sendRedirect("/FinalWeb09/login-admin");
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}

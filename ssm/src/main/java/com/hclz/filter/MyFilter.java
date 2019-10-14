package com.hclz.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
		HttpServletRequest  request=(HttpServletRequest) req;
		String servletPath = request.getServletPath();
		HttpSession session = request.getSession();
		//有session则通行，否则拦截，css/js文件也放行
        if (session.getAttribute("userMsg") != null || servletPath.contains("/static/")) {
            chain.doFilter(req, res);
            return;
		}else {
			if(!(servletPath.equals("/login") | servletPath.equals("/register") | servletPath.equals("/toLogin") | servletPath.equals("/toRegister"))) {
				String contextPath=request.getContextPath();
				response.sendRedirect("/ssm/login");
			}else {
				chain.doFilter(req, res);
			}
		}	
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}

package com.zking.hr.view.contorl.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.zking.hr.pojo.TUser;

public class LoginFilter implements Filter{

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
 		HttpServletRequest httprequest = (HttpServletRequest)request;
		HttpServletResponse httpresponse = (HttpServletResponse)response;
		String uri = httprequest.getRequestURI().toString();
		Object user = httprequest.getSession().getAttribute("user");
		if(user!=null||uri.contains("login/login.jsp")||uri.contains("register.jsp")){
			chain.doFilter(request, response);
		}else{
			String url = httprequest.getRequestURL().toString();
			String path =
			url.replace(uri.subSequence("/HR_Manage_System/".length(), uri.length()),"");
			httpresponse.sendRedirect(path+"login/login.jsp");
		}
		
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

}

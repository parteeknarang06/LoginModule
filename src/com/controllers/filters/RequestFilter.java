package com.controllers.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.model.common.Utility;

public class RequestFilter implements Filter {
	public static Logger logger;
	
	static  {
		logger=Logger.getLogger(RequestFilter.class);
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// place your code here
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse= (HttpServletResponse)response;
		if(httpRequest.getServletPath()==null || httpRequest.getServletPath().equals("/")) {
			Utility.logInfo(logger, httpRequest, "sending to LoginServlet:"+httpRequest.getServletContext().getContextPath());
			Utility.logInfo(logger, httpRequest, "sending to LoginServlet:"+httpRequest.getContextPath());
			if (httpRequest.getContextPath().matches(httpRequest.getServletContext().getContextPath())) {
				httpResponse.sendRedirect(httpRequest.getContextPath()+"/loginCheck");
			}
		} else {
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}
	}

}

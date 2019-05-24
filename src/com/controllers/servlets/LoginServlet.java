package com.controllers.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.common.NameTagParam;
import com.model.config.workflows.Workflow;
import com.model.config.workflows.WorkflowRef;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NameTagParam ntp=new NameTagParam(request);
		Workflow workflow=WorkflowRef.getWorkflows().get(ntp.getHandlerClass());
		List<String> result=workflow.getUrlForAction(request, response,ntp);
		//navigate(request, response, result);
		crossNavigate(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private void navigate(HttpServletRequest request, HttpServletResponse response, List<String> result) throws ServletException, IOException {
		String url = result.get(0);
		Integer navigation = Integer.parseInt(result.get(1));
		switch(navigation) {
			case 1: {
				request.getRequestDispatcher(url).forward(request, response);
				break;
			} case 2: {
				response.sendRedirect(request.getServletContext().getContextPath() + url);
				break;
			} case 3: {
				request.getRequestDispatcher(url).include(request, response);
				break;
			}
		}
	}
	
	private void crossNavigate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("crossrequest", "I am from LoginServlet");
		response.sendRedirect("/spring.mvc/CrossCheckServlet");
		request.getSession().setAttribute("crossrequest", "I am from LoginServlet");
		/*
		ServletContext context = request.getServletContext().getContext("/spring.mvc");
		context.getRequestDispatcher("/CrossCheckServlet").forward(request, response);
		*/
	}
}

package com.model.config.workflows;

import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.common.NameTagParam;

public class WorkflowRepresentation implements Workflow {
	private HashMap<String,String> pagesList=null;
	private HashMap<String,Actions> actions=null;
	private Class<?> handlerClass=null;
	private String workflowName=null;
	
	public WorkflowRepresentation(String workflowName) {
		this.workflowName=workflowName;
	}
	
	@Override
	public HashMap<String, String> getPagesList() {
		return pagesList;
	}
	
	@Override
	public Class<?> getHandlerClass() {
		return handlerClass;
	}
	
	@Override
	public void setPagesList(HashMap<String, String> pagesList) {
		this.pagesList=pagesList;
	}
	
	@Override
	public void setActions(HashMap<String, Actions> actions) {
		this.actions=actions;
	}
	
	@Override
	public void setHandlerClass(Class<?> handlerClass) {
		this.handlerClass=handlerClass;
	}

	@Override
	public List<String> getUrlForAction(HttpServletRequest request, HttpServletResponse response,NameTagParam ntp) {
		return actions.get(ntp.getHandlerMethod()).excecute(request, response,ntp);
	}

	@Override
	public String getWorkflowName() {
		return workflowName;
	}
	
}

package com.model.config.workflows;

import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.common.NameTagParam;

public interface Workflow {
	HashMap<String, String> getPagesList();
	Class<?> getHandlerClass();
	String getWorkflowName();
	void setPagesList(HashMap<String, String> pagesList);
	void setActions(HashMap<String, Actions> actions);
	void setHandlerClass(Class<?> handlerClass);
	List<String> getUrlForAction(HttpServletRequest request, HttpServletResponse response,NameTagParam ntp);
}

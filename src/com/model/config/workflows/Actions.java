package com.model.config.workflows;

import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.common.NameTagParam;

public interface Actions {
	void setResultsList(HashMap<String, Results> resultsList);
	void setWorkflow(WeakReference<Workflow> workflow);
	void setMethod(Method method);
	List<String> execute(HttpServletRequest request, HttpServletResponse response,NameTagParam ntp);
}

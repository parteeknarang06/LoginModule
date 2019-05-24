package com.model.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.common.NameTagParam;
import com.model.common.RowColStore;
import com.model.config.workflows.ActionResult;
import com.model.config.workflows.WorkflowActionResult;

public class LoginHandler {
	
	public ActionResult checkLoginStatus(HttpServletRequest request,HttpServletResponse response,RowColStore rcs,NameTagParam ntp) {
		rcs.dropAllRows();
		return new WorkflowActionResult("NEED_LOGIN");
	}
	
}

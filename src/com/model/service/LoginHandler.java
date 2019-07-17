package com.model.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.model.common.NameTagParam;
import com.model.common.RowColStore;
import com.model.common.Vars;
import com.model.action.Login;
import com.model.action.LoginImpl;
import com.model.common.LoggerUtility;
import com.model.config.workflows.ActionResult;
import com.model.config.workflows.WorkflowActionResult;

public class LoginHandler {
	private static final Logger logger;
	static {
		logger= Logger.getLogger(LoginHandler.class);
	}
	public ActionResult checkLoginStatus(HttpServletRequest request, HttpServletResponse response, RowColStore rcs, NameTagParam ntp) {
		rcs.dropAllRows();
		LoggerUtility.logInfo(logger, request, "Jsessionid size:"+request.getSession().getId().length());
		return new WorkflowActionResult("NEED_LOGIN");
	}
	
	public ActionResult logMeIn(HttpServletRequest request, HttpServletResponse response, RowColStore rcs, NameTagParam ntp) {
		rcs.dropAllRows();
		Login login = new LoginImpl();
		login.createToken(request.getSession().getId());
		rcs.putRowCol(Vars.LOGIN, Vars.TOKEN, login.getToken());
		return new WorkflowActionResult("LOGIN_OK");
	}
}

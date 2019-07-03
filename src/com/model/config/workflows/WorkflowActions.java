package com.model.config.workflows;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

import com.model.common.NameTagParam;
import com.model.common.RowColStore;
import com.model.common.LoggerUtility;
import com.model.common.Vars;

public class WorkflowActions implements Actions {
	private HashMap<String, Results> resultsList = null;
	private WeakReference<Workflow> workflow = null;
	private Method method = null;
	private final static Logger logger;

	static {
		logger = Logger.getLogger(WorkflowActions.class);
	}

	@Override
	public void setResultsList(HashMap<String, Results> resultsList) {
		this.resultsList = resultsList;
	}

	@Override
	public void setWorkflow(WeakReference<Workflow> workflow) {
		this.workflow = workflow;
	}

	@Override
	public void setMethod(Method method) {
		this.method = method;
	}

	@Override
	public List<String> execute(HttpServletRequest request, HttpServletResponse response, NameTagParam ntp) {
		Workflow workflow = null;
		RowColStore rcs = null;
		ActionResult workflowAction = null;

		workflow = this.workflow.get();
		rcs = getRowColStore(request.getSession(), workflow);
		putRequestDetails(request,rcs);
		try {
			workflowAction = (ActionResult) method.invoke(workflow.getHandlerClass().newInstance(),
					WorkflowRef.getArgument(request, response, rcs, ntp));
			rcs.merge(ntp);
			setRowColStore(request.getSession(), workflow, rcs);
		} catch (IllegalAccessException e) {
			LoggerUtility.logError(logger, request, e, "IllegalAccessException occurred during invoking the service layer:" + e.getMessage());
		} catch (InvocationTargetException e) {
			LoggerUtility.logError(logger, request, e, "InvocationTargetException occurred during invoking the service layer:" + e.getMessage());
		} catch (InstantiationException e) {
			LoggerUtility.logError(logger, request, e, "InstantiationException occurred during invoking the service layer:" + e.getMessage());
		}
		return getResult(resultsList.get(workflowAction.getResultName()));
	}

	private static void putRequestDetails(HttpServletRequest request, RowColStore rcs) {
		rcs.putRowCol(Vars.REQUEST, Vars.USER_ADDRESS, request.getRemoteAddr());
		rcs.putRowCol(Vars.REQUEST, Vars.SESSION_ID, request.getSession().getId());
	}

	private List<String> getResult(Results result) {
		return new ArrayList<String>() {
			private static final long serialVersionUID = 1L;
			{
				add(workflow.get().getPagesList().get(result.getDestName()));
				add(result.getNavigation());
			}
		};
	}

	private static RowColStore getRowColStore(HttpSession session, Workflow workflow) {
		if (session.getAttribute(Vars.ROWCOLSTORE_NAME.concat(workflow.getWorkflowName())) != null) {
			return (RowColStore) session.getAttribute(Vars.ROWCOLSTORE_NAME.concat(workflow.getWorkflowName()));
		} else {
			return new RowColStore();
		}
	}

	private static void setRowColStore(HttpSession session, Workflow workflow, RowColStore rcs) {
		session.setAttribute(Vars.ROWCOLSTORE_NAME.concat(workflow.getWorkflowName()), rcs);
	}
}

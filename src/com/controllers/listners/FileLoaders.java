package com.controllers.listners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.model.common.DuplicateWorkflow;
import com.model.config.properties.CoProperties;
import com.model.config.workflows.WorkflowRef;

public class FileLoaders implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		CoProperties.getInstance().loadLog4j(event);
		try {
			WorkflowRef.loadWorkflows(event);
		} catch (DuplicateWorkflow e) {
			e.printStackTrace();
		}
	}

}

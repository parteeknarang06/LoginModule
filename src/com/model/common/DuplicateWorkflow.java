package com.model.common;

public class DuplicateWorkflow extends Exception {
	private static final long serialVersionUID = 1L;
	private String message;
	
	public DuplicateWorkflow(String workflowName) {
		this.message = "Duplicate workflows are defined with name of " + workflowName + " in workflow doc files.";
	}
	public String getMessage() {
		return message;
	}
	
}

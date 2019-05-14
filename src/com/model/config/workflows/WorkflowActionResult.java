package com.model.config.workflows;

public class WorkflowActionResult implements ActionResult {
	private String resultName;
	
	public WorkflowActionResult(String resultName){
		this.resultName=resultName;
	}
	
	@Override
	public String getResultName() {
		return resultName;
	}

}

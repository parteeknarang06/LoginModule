package com.model.config.workflows;

public class WorkflowResults implements Results {
	private String resultName=null;
	private String destName=null;
	private String navigation=null;
	
	@Override
	public void setResultName(String resultName) {
		this.resultName=resultName;
	}
	
	@Override
	public void setDestName(String destName) {
		this.destName=destName;
	}
	
	@Override
	public void setNavigation(String navigation) {
		this.navigation=navigation;
	}
	
	@Override
	public String getResultName() {
		return resultName;
	}
	
	@Override
	public String getDestName() {
		return destName;
	}
	
	@Override
	public String getNavigation() {
		return navigation;
	}
	
} 

package com.model.common;

public class Vars {
	/**
	 * Servlet Context Parameters
	 **/
	public static final String PROP_RELATIVE_PATH;
	public static final String WORKFLOWS_RELATIVE_PATH;
	
	/**
	 * Session Attribute Names 
	 **/
	public static final String ROWCOLSTORE_NAME;
	
	/**
	 * RowColStore rows
	 **/
	public static final String REQUEST;
	public static final String LOGIN;
	
	/**
	 * RowColStore cols
	 **/
	public static final String USER_ADDRESS;
	public static final String SESSION_ID;
	public static final String TOKEN;
	/**
	 * Common Used Values
	 **/
	public static final String BLANK;
	public static final String COMMA;
	public static final String ASSIGNMENT;
	public static final String PIPE;
	
	static {
		/**
		 * Servlet Context Parameters
		 **/
		PROP_RELATIVE_PATH	= "PropertiesRelativePath";
		WORKFLOWS_RELATIVE_PATH = "WorkflowsRelativePath";
		
		/**
		 * Common Used Values
		 **/
		BLANK="";
		COMMA=",";
		ASSIGNMENT="=";
		PIPE="|";
		
		/**
		 * Session Attribute Names 
		 **/
		ROWCOLSTORE_NAME = "_rowcolstoreName_";
		
		/**
		 * RowColStore rows
		 **/
		REQUEST = "_request_";
		LOGIN="_login_";
		
		/**
		 * RowColStore cols
		 **/
		USER_ADDRESS = "_userId_";
		SESSION_ID = "_sessionID_";
		TOKEN="_token_";
	}
}

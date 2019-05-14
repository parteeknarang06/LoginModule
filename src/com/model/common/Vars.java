package com.model.common;

import javax.servlet.ServletContextEvent;

import org.apache.log4j.Logger;

public class Vars {
	private static final Logger logger;
	/**
	 * Application Values
	 */
	private static String CONTEXT_PATH;
	
	/**
	 * Servlet Context Parameters
	 **/
	public static final String APPBASE_PATH;
	public static final String PROP_RELATIVE_PATH;
	public static final String WORKFLOWS_RELATIVE_PATH;
	
	/**
	 * Session Attribute Names 
	 **/
	public static final String ROWCOLSTORE_NAME;
	
	/**
	 * RowColStore rows
	 **/
	public static final String APPLICATION;
	
	/**
	 * RowColStore cols
	 **/
	public static final String USER_ADDRESS;
	public static final String SESSION_ID;
	
	/**
	 * Common Used Values
	 **/
	public static final String BLANK;
	public static final String COMMA;
	public static final String ASSIGNMENT;
	public static final String PIPE;
	
	static {
		logger = Logger.getLogger(Vars.class);
		/**
		 * Servlet Context Parameters
		 **/
		APPBASE_PATH		= "AppBasePath";
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
		APPLICATION = "_application_";
		
		/**
		 * RowColStore cols
		 **/
		USER_ADDRESS = "_userId_";
		SESSION_ID = "_sessionID_";
		
	}
	
	public static void setContextPath(ServletContextEvent event) {
		CONTEXT_PATH = CONTEXT_PATH==null || CONTEXT_PATH.isEmpty() ? event.getServletContext().getContextPath() : CONTEXT_PATH;
		logger.info("Context path is:"+CONTEXT_PATH);
	}
	
	public static String getContextPath() {
		return CONTEXT_PATH;
	}
	
}

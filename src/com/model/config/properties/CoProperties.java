package com.model.config.properties;

import javax.servlet.ServletContextEvent;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.model.common.Vars;

/**
 * It is singleton class which load all the property files
 * **/
public class CoProperties {
	
	private static CoProperties coProperties=null;
	private static Logger logger;
	
	private CoProperties() {
		/**
		 * This is singleton Class
		 * */
	}
	
	public static synchronized CoProperties getInstance() {
		if(coProperties==null) {
			coProperties=new CoProperties();
		}
		return coProperties;
	}
	
	public void loadLog4j(ServletContextEvent event) {
		String appBasePath=null;
		String propRelativePath=null;
		
		appBasePath=event.getServletContext().getInitParameter(Vars.APPBASE_PATH);
		propRelativePath=event.getServletContext().getInitParameter(Vars.PROP_RELATIVE_PATH);
		PropertyConfigurator.configure(appBasePath.concat(propRelativePath+"log4j.properties"));
		logger=Logger.getLogger(CoProperties.class);
		logger.info("It is info logger");
		logger.debug("It is debug logger");
	}
}

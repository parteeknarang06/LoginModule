package com.model.config.properties;

import javax.servlet.ServletContextEvent;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import com.model.common.Vars;

/**
 * It is singleton class which load all the property files
 * **/
public class CoProperties {
	private static final CoProperties coProperties;
	private static Logger logger;
	
	static {
		coProperties=new CoProperties();
	}
	
	private CoProperties() {
		/**
		 * This is singleton Class
		 * */
	}
	
	public static CoProperties getInstance() {
		return coProperties;
	}
	
	public void loadLog4j(ServletContextEvent event) {
		String appBasePath=event.getServletContext().getRealPath("/");
		String propRelativePath=event.getServletContext().getInitParameter(Vars.PROP_RELATIVE_PATH);
		PropertyConfigurator.configure(appBasePath.concat(propRelativePath+"log4j.properties"));
		logger=Logger.getLogger(CoProperties.class);
		logger.info("It is info logger");
		logger.debug("It is debug logger");
	}
	
}

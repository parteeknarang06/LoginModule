package com.controllers.listners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.model.common.Vars;

public class ContentLoaders implements ServletContextListener {
	
  @Override
  public void contextInitialized(ServletContextEvent event) {
	Vars.setContextPath(event);
  }
  
}

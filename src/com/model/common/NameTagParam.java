package com.model.common;

import java.util.Enumeration;
import java.util.StringTokenizer;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

public class NameTagParam extends RowColStore {
	private static final Logger logger;
	private String handlerClass;
	private String handlerMethod;
	
	static {
		logger=Logger.getLogger(NameTagParam.class);
	}
	
	public NameTagParam(HttpServletRequest request) {
		Enumeration<String> parmsNames= null; 
		String paramName=null;
		
		parmsNames=request.getParameterNames();
		while(parmsNames.hasMoreElements()) {
			paramName=parmsNames.nextElement();
			if(paramName!=null && !paramName.isEmpty() && paramName.indexOf(Vars.COMMA)!=-1) {
				load(request,paramName);
			}
		}
		handlerClass = handlerClass==null  || handlerClass.isEmpty()  ? "LOGIN" : handlerClass;
		handlerMethod= handlerMethod==null || handlerMethod.isEmpty() ? "CHECK_STATUS" : handlerMethod;
	}
	
	private void load(HttpServletRequest request,String paramName) {
		StringTokenizer token=null;
		String tokenstr=null;
		String row=null;
		String col=null;
		String temp=Vars.BLANK;
		String[] paramValues=null;
		
		try {
			paramValues=request.getParameterValues(paramName);
			token=new StringTokenizer(paramName,Vars.COMMA);
			while(token.hasMoreElements()) {
				tokenstr=token.nextToken();
				switch(tokenstr.substring(0, tokenstr.indexOf(Vars.ASSIGNMENT))) {
					case "r":
						row=tokenstr.substring(tokenstr.indexOf(Vars.ASSIGNMENT)+1);
						break;
					case "c":
						col=tokenstr.substring(tokenstr.indexOf(Vars.ASSIGNMENT)+1);
						break;
					case "hm":
						handlerMethod=tokenstr.substring(tokenstr.indexOf(Vars.ASSIGNMENT)+1);
						break;
					case "hc":
						handlerClass=tokenstr.substring(tokenstr.indexOf(Vars.ASSIGNMENT)+1);
						break;
				}
			}
			for(int i=0; i<paramValues.length && !paramValues[i].trim().isEmpty();i++) {
				temp=temp.concat(paramValues[i].trim()).concat(Vars.PIPE);
			}
			putRowCol(row, col, !temp.isEmpty() ? temp.substring(0, temp.length()-1) : Vars.BLANK);
		} catch(Exception ex) {
			Utility.logError(logger, request, ex, "Exception occurred while taking params:"+ex.getMessage());
		}
	}
	
	public String getHandlerClass() {
		return handlerClass;
	}

	public String getHandlerMethod() {
		return handlerMethod;
	}

}

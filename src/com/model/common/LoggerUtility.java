package com.model.common;

import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

public class LoggerUtility {
	
	public static void logInfo(Logger logger,HttpServletRequest request,String Message) {
		logger.info("userAddress:"+request.getRemoteAddr()+"; sessionId:"+request.getSession().getId()+"; Message:"+Message);
	}
	
	public static void logInfo(Logger logger,RowColStore rcs,String Message) {
		logger.info("userAddress: "+rcs.getRowCol(Vars.REQUEST, Vars.USER_ADDRESS)+"; sessionId: "+rcs.getRowCol(Vars.REQUEST, Vars.SESSION_ID)+"; Message: "+Message);
	}
	
	public static void logError(Logger logger,HttpServletRequest request,Exception ex,String Message) {
		logger.error("userAddress:"+request.getRemoteAddr()+"; sessionId:"+request.getSession().getId()+"; Message:"+Message,ex);
	}
}

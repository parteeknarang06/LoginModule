package com.model.action;

import java.util.Random;

import org.apache.log4j.Logger;

public class LoginImpl implements Login{
	private static final Logger logger ;
	private StringBuilder token = new StringBuilder();
	static {
		logger = Logger.getLogger(LoginImpl.class);
	}
	
	@Override
	public void createToken(String sessionId) {
		Random random=new Random();
		do {
			int randomNum=random.nextInt(sessionId.length());
			char sessionChar = sessionId.charAt(randomNum); 
			token.append(String.valueOf(randomNum)+sessionChar);
		} while(token.length()<17);
	}
	
	@Override
	public String getToken() {
		return token.toString();
	}
	
}

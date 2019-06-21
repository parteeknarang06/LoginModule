package com.model.action;

import java.util.Random;

import org.apache.log4j.Logger;

public class Login {
	private static final Logger logger ;
	private StringBuilder token;
	static {
		logger = Logger.getLogger(Login.class);
	}
	
	public void createToken(String sessionId) {
		Random random=new Random();
		token = new StringBuilder();
		do {
			int randomNum=random.nextInt(sessionId.length());
			char sessionChar = sessionId.charAt(randomNum); 
			token.append(String.valueOf(randomNum)+sessionChar);
		} while(token.length()<17);
	}
	
}

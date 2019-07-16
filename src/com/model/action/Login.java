package com.model.action;

public interface Login {
	void createToken(String sessionId);
	String getToken();
}

package com.amazon.app;

public class Session {

	
	private Long sessionId;

	public Session(Long sessionId) {
		super();
		this.sessionId = sessionId;
	}

	public Long getSessionId() {
		return sessionId;
	}

	public void setSessionId(Long sessionId) {
		this.sessionId = sessionId;
	}
	
}

package com.amazon.app;

public class SessionManager {
	
	
	private static Session session;

	public static Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		SessionManager.session = session;
	}
	
	
	

}

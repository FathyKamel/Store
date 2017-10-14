package com.store.ws.system.exception.basic;

public class BasicException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2190829954285818321L;
	protected int errorCode;
	
	public BasicException(String cause) {
		super(cause);
		System.out.println("SENT EXCEPTION CAUSE: "+cause);
	}

	public int getErrorCode() {
		return errorCode;
	}
}

package com.store.ws.service.exception;

import com.store.system.exception.basic.BasicException;



public class OperationFailureException extends BasicException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1188560136299911839L;

	public OperationFailureException(String cause) {
		super(cause);
		this.errorCode = 500;
	}

	
}

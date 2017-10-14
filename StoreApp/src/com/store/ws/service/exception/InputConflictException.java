package com.store.ws.service.exception;

import com.store.system.exception.basic.BasicException;


public class InputConflictException extends BasicException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7981116146481439687L;

	public InputConflictException(String cause) {
		super(cause);
		this.errorCode = 409;
	}

}

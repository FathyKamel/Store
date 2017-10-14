package com.store.ws.service.exception;

import com.store.system.exception.basic.BasicException;



public class UnauthorizedRequestException extends BasicException {

	public UnauthorizedRequestException(String cause) {
		super(cause);
		this.errorCode = 403;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 3274460756260115509L;

}

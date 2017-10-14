package com.store.ws.service.exception;

import com.store.system.exception.basic.BasicException;



public class InvalidParametersException extends BasicException {

	public InvalidParametersException(String cause) {
		super(cause);
		// TODO Auto-generated constructor stub
		this.errorCode = 400;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 4116120939903044012L;

}

package com.store.ws.service.exception;

import com.store.system.exception.basic.BasicException;



public class UnsupportedRequestEcxeption extends BasicException {

	public UnsupportedRequestEcxeption(String cause) {
		super(cause);
		this.errorCode = 405;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 8574243177433807938L;

}

package com.store.database.exception;

import com.store.system.exception.basic.BasicException;

public class UnavailableCachedObjectException extends BasicException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1829434908935548267L;

	public UnavailableCachedObjectException(String cause) {
		super(cause);
	}

}

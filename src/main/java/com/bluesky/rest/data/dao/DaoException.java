package com.bluesky.rest.data.dao;


public class DaoException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Throwable cause;
	
	public DaoException(Throwable cause) {
		super(cause.getClass().getName() + cause.getMessage());
		this.cause = cause;
	}
	
	public DaoException(String msg, Throwable cause){
		super(msg,cause);
		this.cause = cause;
	}

	public Throwable getCause() {
		return cause;
	}
}

package com.rak.quick.assignment.exception;

public class InvalidUserAccessException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidUserAccessException(String errMessage) {
		super(errMessage);
	}
}

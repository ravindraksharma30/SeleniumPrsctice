package com.homedepot.mm.po.allocationteamdata.exception;

/**
 * InvalidQueryParamException will be thrown on invalid query params.
 * 
 * Created by gxk8870 on 12/27/16.
 */
public class InvalidQueryParamException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidQueryParamException() {
		super();
	}

	/**
	 *
	 * @param message
	 */
	public InvalidQueryParamException(String message) {
		super(message);
	}
}

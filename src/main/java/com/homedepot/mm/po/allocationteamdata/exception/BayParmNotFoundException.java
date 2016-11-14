/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.exception;

/**
 * @author axd8472
 *
 */
public class BayParmNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6797723627685651690L;

	/**
	 * 
	 */
	public BayParmNotFoundException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public BayParmNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public BayParmNotFoundException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public BayParmNotFoundException(Throwable cause) {
		super(cause);
	}

}

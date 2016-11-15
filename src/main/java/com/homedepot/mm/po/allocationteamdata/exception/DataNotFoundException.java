/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.exception;

/**
 * DataNotFoundException is thrown when no records found in database
 * 
 * @author axd8472 & @author spv5283
 *
 */
public class DataNotFoundException extends Exception {

	private static final long serialVersionUID = 6797723627685651690L;

	public DataNotFoundException() {
		super();
	}

	/**
	 * 
	 * @param message
	 */
	public DataNotFoundException(String message) {
		super(message);
	}

}

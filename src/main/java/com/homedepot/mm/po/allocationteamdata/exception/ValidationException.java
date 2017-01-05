/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.exception;

import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;

/**
 * ValidationException will be thrown on validating DTOs during POST/Create
 * operation.
 * 
 * @author gxk8870
 *
 */
public class ValidationException extends BindException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1110894268818627420L;

	/**
	 * 
	 * @param bindingResult
	 */
	public ValidationException(BindingResult bindingResult) {
		super(bindingResult);
	}

}

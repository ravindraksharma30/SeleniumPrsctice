/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.dto;

import org.springframework.http.HttpStatus;

import lombok.Data;

/**
 * ErrorDTO is used to
 * 
 * @author axd8472 & @author spv5283
 *
 */
@Data
public class ErrorDTO {

	/**
	 * 
	 */
	private String message;

	/**
	 * 
	 */
	private HttpStatus error;
	/**
	 * 
	 */
	private String path;
	/**
	 * 
	 */
	private int status;
	/**
	 * 
	 */
	private String exception;

	/**
	 * 
	 */
	public ErrorDTO() {

	}

	/**
	 * 
	 * @param message
	 * @param error
	 * @param path
	 * @param statusCode
	 * @param exception
	 */
	public ErrorDTO(String message, HttpStatus error, String path, int status, String exception) {
		this.message = message;
		this.error = error;
		this.path = path;
		this.status = status;
		this.exception = exception;

	}

}

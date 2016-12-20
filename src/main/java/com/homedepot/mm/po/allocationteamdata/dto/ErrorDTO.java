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

	private String message;
	private HttpStatus statusCode;
	private String url;

	public ErrorDTO() {

	}

	/**
	 * 
	 * @param message
	 * @param statusCode
	 */
	public ErrorDTO(String message, HttpStatus statusCode, String url) {
		this.message = message;
		this.statusCode = statusCode;
		this.url = url;

	}

}

/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.dto;

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
	private int statusCode;
	private String url;

	/**
	 * 
	 * @param message
	 * @param statusCode
	 */
	public ErrorDTO(String message, int statusCode, String url) {
		this.message = message;
		this.statusCode = statusCode;
		this.url = url;

	}

}

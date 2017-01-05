/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.homedepot.mm.po.allocationteamdata.dto.ErrorDTO;

import lombok.Data;

/**
 * Returns JSON response for {@link ErrorDTO}
 * 
 * @author gxk8870
 *
 */
@JsonInclude(Include.NON_NULL)
@Data
public class ErrorResponse {
	/**
	 * 
	 */

	@JsonProperty("errors")
	private List<ErrorDTO> errors;
	/**
	 * 
	 */
	@JsonProperty("error")
	private ErrorDTO error;

}

/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.homedepot.mm.po.allocationteamdata.domain.OverageDaysResource;

import lombok.Data;

/**
 * Returns JSON response for OverageDays
 * 
 * @author gxk8870
 *
 */
@JsonInclude(Include.NON_NULL)
@Data
public class OverageDaysResponse {
	/**
	 * 
	 */
	@JsonProperty("overageDays")
	private List<OverageDaysResource> overageDaysResources;

}

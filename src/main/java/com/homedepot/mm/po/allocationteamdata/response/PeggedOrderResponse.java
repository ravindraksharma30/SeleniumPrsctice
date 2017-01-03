/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.homedepot.mm.po.allocationteamdata.domain.PeggedOrderResource;

import lombok.Data;

/**
 * Returns JSON response for PeggedOrder
 * 
 * @author gxk8870
 *
 */
@JsonInclude(Include.NON_NULL)
@Data
public class PeggedOrderResponse {
	/**
	 * 
	 */
	@JsonProperty("peggedOrder")
	private PeggedOrderResource peggedOrderResource;

}

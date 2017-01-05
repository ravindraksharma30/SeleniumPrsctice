/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.homedepot.mm.po.allocationteamdata.domain.AllocationOnBoardResource;

import lombok.Data;

/**
 * Returns JSON response for {link @AllocationOnBoard}
 * 
 * @author gxk8870
 *
 */
@JsonInclude(Include.NON_NULL)
@Data
public class AllocationOnBoardResponse {

	/**
	 * 
	 */
	@JsonProperty("allocationOnBoards")
	private List<AllocationOnBoardResource> allocationOnBoardResources;

}

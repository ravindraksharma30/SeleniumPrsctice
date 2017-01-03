/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.controller.api;

import org.springframework.http.ResponseEntity;

import com.homedepot.mm.po.allocationteamdata.exception.InvalidQueryParamException;
import com.homedepot.mm.po.allocationteamdata.response.SDCTargetInventoryResponse;

/**
 * Defines an API for SDCTargetInventoryController. This is used to serve an
 * entry point for SDCTargetInventory services.
 * 
 * @author axd8472
 *
 */
public interface SDCTargetInventoryApi {

	/**
	 * 
	 */
	public static final String SEARCH_PATH = "/findSDCTargetInventories";

	/**
	 * @see com.homedepot.mm.po.allocationteamdata.controller.SDCTargetInventoryController#findSdcTargetInventory()
	 * @param locationId
	 * @param skuNumber
	 * @param activeFlag
	 * @return
	 * @throws InvalidQueryParamException
	 */

	public ResponseEntity<SDCTargetInventoryResponse> findSdcTargetInventory(final String locationId,
			final String skuNumber, final String activeFlag) throws InvalidQueryParamException;

}

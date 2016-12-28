/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.controller.api;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.homedepot.mm.po.allocationteamdata.domain.SDCTargetInventoryResource;
import com.homedepot.mm.po.allocationteamdata.exception.InvalidQueryParamException;

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
	 * 
	 * @param locationId
	 * @param skuNumber
	 * @param activeFlag
	 * @return
	 * @throws InvalidQueryParamException
	 */

	public ResponseEntity<List<SDCTargetInventoryResource>> getSdcTargetInventory(final String locationId,
			final String skuNumber, final String activeFlag) throws InvalidQueryParamException;

}

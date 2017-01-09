/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.controller.api;

import org.springframework.http.ResponseEntity;

import com.homedepot.mm.po.allocationteamdata.controller.SDCTargetInventoryController;
import com.homedepot.mm.po.allocationteamdata.domain.SDCTargetInventoryResource;
import com.homedepot.mm.po.allocationteamdata.exception.InvalidQueryParamException;
import com.homedepot.mm.po.allocationteamdata.services.SDCTargetInventoryService;

/**
 * Defines an API for {@link SDCTargetInventoryController}. This is used to
 * serve an entry point for {@link SDCTargetInventoryService}.
 * 
 * @author axd8472
 *
 */
public interface SDCTargetInventoryApi {

	/**
	 * 
	 */
	public static final String SEARCH_PATH = "/findSDCTargetInventory";

	/**
	 * @see com.homedepot.mm.po.allocationteamdata.controller.SDCTargetInventoryController#findSdcTargetInventory()
	 * @param locationId
	 * @param skuNumber
	 * @param activeFlag
	 * @return
	 * @throws InvalidQueryParamException
	 */

	public ResponseEntity<SDCTargetInventoryResource> findSdcTargetInventory(final String locationId,
			final String skuNumber, final String activeFlag) throws InvalidQueryParamException;

}

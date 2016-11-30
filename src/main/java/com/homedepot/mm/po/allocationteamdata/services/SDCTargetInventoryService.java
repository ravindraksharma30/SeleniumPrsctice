package com.homedepot.mm.po.allocationteamdata.services;

import java.util.List;

import com.homedepot.mm.po.allocationteamdata.entities.teradata.SDCTargetInventory;
import com.homedepot.mm.po.allocationteamdata.exception.DataNotFoundException;

/**
 * 
 * SDCTargetInventoryService is to do CRUD operations on the data retrieved from
 * SDCTargetInventoryRepository
 * 
 * @author axd8472 & @author spv5283
 *
 */
public interface SDCTargetInventoryService {

	/**
	 * Retrieves list of SDCTargetInventory using LocationId and ActiveFlag
	 * 
	 * @param locationId
	 * @param activeFlag
	 * @return
	 * @throws DataNotFoundException
	 */

	public List<SDCTargetInventory> getSDCTargetInventory(final String locationId, final String activeFlag);
}
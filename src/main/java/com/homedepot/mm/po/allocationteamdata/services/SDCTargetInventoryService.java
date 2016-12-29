package com.homedepot.mm.po.allocationteamdata.services;

import java.util.List;

import com.homedepot.mm.po.allocationteamdata.entities.teradata.SDCTargetInventory;

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
	 * @see com.homedepot.mm.po.allocationteamdata.services.impl.SDCTargetInventoryServiceImpl#findSDCTargetInventory()
	 *      Retrieves list of SDCTargetInventory using LocationId and ActiveFlag
	 * 
	 * @param locationId
	 * @param skuNumber
	 * @param activeFlag
	 * @return
	 */
	public List<SDCTargetInventory> findSDCTargetInventory(final String locationId, final String skuNumber,
			final String activeFlag);
}

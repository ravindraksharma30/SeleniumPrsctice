package com.homedepot.mm.po.allocationteamdata.services;

import com.homedepot.mm.po.allocationteamdata.entities.teradata.SDCTargetInventory;
import com.homedepot.mm.po.allocationteamdata.repository.teradata.SDCTargetInventoryRepository;

/**
 * 
 * Defines an API for performing business logic around CRUD operations using
 * {@link SDCTargetInventoryRepository}.
 * 
 * 
 * @author axd8472 & @author spv5283
 *
 */
public interface SDCTargetInventoryService {

	/**
	 * @see com.homedepot.mm.po.allocationteamdata.services.impl.SDCTargetInventoryServiceImpl#findSDCTargetInventory()
	 * 
	 *      Retrieves list of SDCTargetInventory using LocationId and ActiveFlag
	 * 
	 * @param locationId
	 * @param skuNumber
	 * @param activeFlag
	 * @return
	 */
	public SDCTargetInventory findSDCTargetInventory(final String locationId, final String skuNumber,
			final String activeFlag);
}

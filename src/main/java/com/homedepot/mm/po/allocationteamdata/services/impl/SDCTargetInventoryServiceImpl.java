package com.homedepot.mm.po.allocationteamdata.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homedepot.mm.po.allocationteamdata.entities.teradata.SDCTargetInventory;
import com.homedepot.mm.po.allocationteamdata.repository.teradata.SDCTargetInventoryRepository;
import com.homedepot.mm.po.allocationteamdata.services.SDCTargetInventoryService;

/**
 * Implementation of {@link SDCTargetInventoryService} API by retrieving the
 * result set from the {@link SDCTargetInventoryRepository}.
 * 
 * @author axd8472 & @author spv5283
 *
 */
@Service("SDCTargetInventoryServiceImpl")
public class SDCTargetInventoryServiceImpl implements SDCTargetInventoryService {

	/**
	 * 
	 */
	@Autowired
	private SDCTargetInventoryRepository sdcTargetInventoryRepository;

	/**
	 * @see com.homedepot.mm.po.allocationteamdata.services.SDCTargetInventoryService
	 *      #findSDCTargetInventory(java.lang.String, java.lang.String,
	 *      java.lang.String)
	 * 
	 * @param locationId
	 * @param activeFlag
	 * @param skuNumber
	 * @return
	 * 
	 */
	@Override
	public List<SDCTargetInventory> findSDCTargetInventory(final String locationId, final String skuNumber,
			final String activeFlag) {

		final List<SDCTargetInventory> sdcTargetInventories = sdcTargetInventoryRepository
				.findByLocationidAndProductcodeAndActiveflag(locationId, skuNumber, activeFlag);

		return sdcTargetInventories;
	}

}

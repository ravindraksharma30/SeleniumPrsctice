package com.homedepot.mm.po.allocationteamdata.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homedepot.mm.po.allocationteamdata.entities.teradata.SDCTargetInventory;
import com.homedepot.mm.po.allocationteamdata.repository.teradata.SDCTargetInventoryRepository;
import com.homedepot.mm.po.allocationteamdata.services.SDCTargetInventoryService;

/**
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
	 * 
	 * @param locationId
	 * @param activeFlag
	 * @param skuNumber
	 * @return
	 * 
	 */
	@Override
	public List<SDCTargetInventory> getSDCTargetInventory(final String locationId, final String skuNumber,
			final String activeFlag) {

		final List<SDCTargetInventory> sdcTargetInventories = sdcTargetInventoryRepository
				.findByLocationidAndProductcodeAndActiveflag(locationId, skuNumber, activeFlag);

		return sdcTargetInventories;
	}

}

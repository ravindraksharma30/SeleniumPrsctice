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

	@Autowired
	SDCTargetInventoryRepository sdcTargetInventoryRepository;

	@Override
	/**
	 * 
	 * @param locationId
	 * @param activeFlag
	 * @return
	 * @throws DataNotFoundException
	 */
	public List<SDCTargetInventory> getSDCTargetInventory(final String locationId, final String activeFlag) {

		final List<SDCTargetInventory> sdcTargetInventories = sdcTargetInventoryRepository
				.findByLocationidAndActiveflag(locationId, activeFlag);

		return sdcTargetInventories;
	}

}
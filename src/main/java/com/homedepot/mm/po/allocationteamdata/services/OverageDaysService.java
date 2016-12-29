package com.homedepot.mm.po.allocationteamdata.services;

import java.util.List;

import com.homedepot.mm.po.allocationteamdata.entities.teradata.OverageDays;

/**
 * Performs CRUD operations on the data retrieved from OverageDaysRepository.
 * 
 * @author gxk8870
 *
 */
public interface OverageDaysService {

	/**
	 * @see com.homedepot.mm.po.allocationteamdata.services.impl.OverageDaysServiceImpl#findOverageDays()
	 * @param locationId
	 * @param skuNumber
	 * @param activeFlag
	 * @return
	 */
	public List<OverageDays> findOverageDays(final String locationId, final String skuNumber, final String activeFlag);
}

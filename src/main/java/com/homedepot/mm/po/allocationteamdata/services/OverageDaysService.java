package com.homedepot.mm.po.allocationteamdata.services;

import java.util.List;

import com.homedepot.mm.po.allocationteamdata.entities.teradata.OverageDays;
import com.homedepot.mm.po.allocationteamdata.repository.teradata.OverageDaysRepository;

/**
 * Defines an API for performing business logic around CRUD operations using
 * {@link OverageDaysRepository}.
 * 
 * @author gxk8870
 *
 */
public interface OverageDaysService {

	/**
	 * @see com.homedepot.mm.po.allocationteamdata.services.impl.OverageDaysServiceImpl#findOverageDays()
	 * 
	 * @param locationId
	 * @param skuNumber
	 * @param activeFlag
	 * @return
	 */
	public List<OverageDays> findOverageDays(final String locationId, final String skuNumber, final String activeFlag);
}

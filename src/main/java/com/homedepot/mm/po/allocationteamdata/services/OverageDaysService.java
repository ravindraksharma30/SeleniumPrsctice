package com.homedepot.mm.po.allocationteamdata.services;

import com.homedepot.mm.po.allocationteamdata.entities.teradata.OverageDay;
import com.homedepot.mm.po.allocationteamdata.repository.teradata.OverageDayRepository;

/**
 * Defines an API for performing business logic around CRUD operations using
 * {@link OverageDayRepository}.
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
	public OverageDay findOverageDay(final String locationId, final String skuNumber, final String activeFlag);
}

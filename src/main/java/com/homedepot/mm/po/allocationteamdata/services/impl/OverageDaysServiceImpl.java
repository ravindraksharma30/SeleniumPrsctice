package com.homedepot.mm.po.allocationteamdata.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homedepot.mm.po.allocationteamdata.entities.teradata.OverageDay;
import com.homedepot.mm.po.allocationteamdata.repository.teradata.OverageDayRepository;
import com.homedepot.mm.po.allocationteamdata.services.OverageDaysService;

/**
 * Implementation of {@link OverageDaysService} API by retrieving the result set
 * from the {@link OverageDayRepository}.
 * 
 * @author axd8472
 *
 */
@Service("OverageDaysServiceImpl")
public class OverageDaysServiceImpl implements OverageDaysService {

	/**
	 * 
	 */
	@Autowired
	private OverageDayRepository overageDaysRepository;

	/**
	 * 
	 * @see com.homedepot.mm.po.allocationteamdata.services.OverageDaysService#
	 *      findOverageDays(java.lang.String, java.lang.String,
	 *      java.lang.String)
	 * 
	 * @param locationId
	 * @param skuNumber
	 * @param activeFlag
	 * @return overageDays
	 */

	@Override
	public OverageDay findOverageDay(final String locationId, final String skuNumber, final String activeFlag) {
		return overageDaysRepository.findByLocationidAndProductcodeAndActiveflag(locationId, skuNumber, activeFlag);
	}
}

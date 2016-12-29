package com.homedepot.mm.po.allocationteamdata.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homedepot.mm.po.allocationteamdata.entities.teradata.OverageDays;
import com.homedepot.mm.po.allocationteamdata.repository.teradata.OverageDaysRepository;
import com.homedepot.mm.po.allocationteamdata.services.OverageDaysService;

/**
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
	private OverageDaysRepository overageDaysRepository;

	/**
	 * @param locationId
	 * @param skuNumber
	 * @param activeFlag
	 * @return overageDays
	 */
	@Override
	public List<OverageDays> findOverageDays(final String locationId, final String skuNumber, final String activeFlag) {
		final List<OverageDays> overageDays = overageDaysRepository
				.findByLocationidAndProductcodeAndActiveflag(locationId, skuNumber, activeFlag);
		return overageDays;
	}
}

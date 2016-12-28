/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homedepot.mm.po.allocationteamdata.entities.teradata.BayParm;
import com.homedepot.mm.po.allocationteamdata.repository.teradata.BayParmRepository;
import com.homedepot.mm.po.allocationteamdata.services.BayParmService;

/**
 * @author axd8472 & @author spv5283
 *
 */
@Service("BayParmServiceImpl")
public class BayParmServiceImpl implements BayParmService {

	@Autowired
	private BayParmRepository bayParmRepository;

	/**
	 * 
	 * @param locationId
	 * @param activeFlag
	 * @param skuNumber
	 * @return bayparms
	 * 
	 */
	@Override
	public List<BayParm> getBayParm(final String locationId, final String skuNumber, final String activeFlag) {

		final List<BayParm> bayparms = bayParmRepository.findByLocationidAndProductcodeAndActiveflag(locationId,
				skuNumber, activeFlag);

		return bayparms;
	}

}

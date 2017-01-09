/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homedepot.mm.po.allocationteamdata.entities.teradata.BayParm;
import com.homedepot.mm.po.allocationteamdata.repository.teradata.BayParmRepository;
import com.homedepot.mm.po.allocationteamdata.services.BayParmService;

/**
 * Implementation of {@link BayParmService} API by retrieving the result set
 * from the {@link BayParmRepository}.
 * 
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
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.homedepot.mm.po.allocationteamdata.services.BayParmService#
	 * findBayParms(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public BayParm findBayParm(final String locationId, final String skuNumber, final String activeFlag) {

		return bayParmRepository.findByLocationidAndProductcodeAndActiveflag(locationId, skuNumber, activeFlag);
	}

}

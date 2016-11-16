/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homedepot.mm.po.allocationteamdata.entities.teradata.BayParm;
import com.homedepot.mm.po.allocationteamdata.exception.DataNotFoundException;
import com.homedepot.mm.po.allocationteamdata.repository.teradata.BayParmRepository;
import com.homedepot.mm.po.allocationteamdata.services.BayParmService;

/**
 * @author axd8472 & @author spv5283
 *
 */
@Service("BayParmServiceImpl")
public class BayParmServiceImpl implements BayParmService {

	@Autowired
	BayParmRepository bayParmRepository;

	@Override
	/**
	 * 
	 * @param locationId
	 * @param activeFlag
	 * @return
	 * @throws DataNotFoundException
	 */
	public List<BayParm> getBayParm(final String locationId, final String activeFlag) throws DataNotFoundException {

		final List<BayParm> bayparms = bayParmRepository.findByLocationidAndActiveflag(locationId, activeFlag);

//		if (bayparms.isEmpty())
//			throw new DataNotFoundException("BayParm Records Not Found");
		return bayparms;
	}

}

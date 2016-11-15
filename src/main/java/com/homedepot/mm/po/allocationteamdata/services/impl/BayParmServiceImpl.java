/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homedepot.mm.po.allocationteamdata.entities.teradata.BayParmEntityDTO;
import com.homedepot.mm.po.allocationteamdata.exception.BayParmNotFoundException;
import com.homedepot.mm.po.allocationteamdata.repository.teradata.TeradataAllocationJpaRepository;
import com.homedepot.mm.po.allocationteamdata.services.BayParmService;

/**
 * @author axd8472
 *
 */
@Service("BayParmServiceImpl")
public class BayParmServiceImpl implements BayParmService {

	@Autowired
	TeradataAllocationJpaRepository bayParmRepository;

	@Override
	public List<BayParmEntityDTO> getBayParm(final String locationId, final String activeFlag) throws BayParmNotFoundException {

		final List<BayParmEntityDTO> bayparms = bayParmRepository.findByLocationidAndActiveflag(locationId, activeFlag);

		if (bayparms.isEmpty())
			throw new BayParmNotFoundException("Bay Parm Not Found");
		return bayparms;
	}

}

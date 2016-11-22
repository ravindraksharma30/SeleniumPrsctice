	/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.services;

import java.util.List;

import com.homedepot.mm.po.allocationteamdata.entities.teradata.BayParm;
import com.homedepot.mm.po.allocationteamdata.exception.DataNotFoundException;

/**
 * BayParmService is to do CRUD operations on the data retrieved from
 * BayParmRepository
 * 
 * @author axd8472 & @author spv5283
 *
 */
public interface BayParmService {

	/**
	 * Retrieves list of BayParm using LocationId and ActiveFlag
	 * 
	 * @param locationId
	 * @param activeFlag
	 * @return
	 * @throws DataNotFoundException
	 */
	public List<BayParm> getBayParm(final String locationId, final String activeFlag) throws DataNotFoundException;

}

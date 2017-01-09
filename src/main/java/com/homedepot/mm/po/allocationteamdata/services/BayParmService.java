/**
* 
*/
package com.homedepot.mm.po.allocationteamdata.services;

import com.homedepot.mm.po.allocationteamdata.entities.teradata.BayParm;
import com.homedepot.mm.po.allocationteamdata.repository.teradata.BayParmRepository;

/**
 * Defines an API for performing business logic around CRUD operations using
 * {@link BayParmRepository}.
 * 
 * @author axd8472 & @author spv5283
 *
 */
public interface BayParmService {

	/**
	 * Retrieves list of BayParms using LocationId, SkuNumber and ActiveFlag
	 * 
	 * @see com.homedepot.mm.po.allocationteamdata.services.impl.BayParmServiceImpl#findBayParms()
	 *
	 *
	 * @param locationId
	 * @param skuNumber
	 * @param activeFlag
	 * @return
	 */
	public BayParm findBayParm(final String locationId, final String skuNumber, final String activeFlag);

}

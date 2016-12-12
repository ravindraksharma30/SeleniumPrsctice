/**
* 
*/
package com.homedepot.mm.po.allocationteamdata.services;

import java.util.List;

import com.homedepot.mm.po.allocationteamdata.entities.teradata.BayParm;

/**
 * BayParmService is to do CRUD operations on the data retrieved from
 * BayParmRepository
 * 
 * @author axd8472 & @author spv5283
 *
 */
public interface BayParmService {

	/**
	 * Retrieves list of BayParm using LocationId, SkuNumber and ActiveFlag
	 * 
	 * @param locationId
	 * @param skuNumber
	 * @param activeFlag
	 * @return
	 */
	public List<BayParm> getBayParm(final String locationId, final String skuNumber, final String activeFlag);

}

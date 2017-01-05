/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.services;

import com.homedepot.mm.po.allocationteamdata.dto.TransloadSkuDTO;

/**
 * 
 * @author axd8472
 *
 */
public interface AllocationService {
	/**
	 * @see com.homedepot.mm.po.allocationteamdata.services.impl.AllocationServiceImpl#createAllocation()
	 * @param transloadSkuDTO
	 */
	public void createAllocation(final TransloadSkuDTO transloadSkuDTO);
}

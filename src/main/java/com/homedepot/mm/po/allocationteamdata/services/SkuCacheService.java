package com.homedepot.mm.po.allocationteamdata.services;

import com.homedepot.mm.po.allocationteamdata.entities.tldallocation.oracle.SkuCache;

/**
 * 
 * @author gxk8870
 *
 */
public interface SkuCacheService {

	/**
	 * Retrieves cached data based on the transload and SKU numbers.
	 * 
	 * @see com.homedepot.mm.po.allocationteamdata.services.impl.SkuCacheServiceImpl#getSkuCache()
	 * @param transloadNumber
	 * @param skuNumber
	 * @return
	 */
	public SkuCache findSkuCache(final String transloadNumber, final Integer skuNumber);

	/**
	 * Inserts cached data based on the transload and SKU numbers.
	 * 
	 * @see com.homedepot.mm.po.allocationteamdata.services.impl.SkuCacheServiceImpl#setSkuCache()
	 * @param transloadNumber
	 * @param skuNumber
	 */
	public SkuCache insertSkuCache(String transloadDcNumber, Integer skuNumber, String createProgramId);
}

package com.homedepot.mm.po.allocationteamdata.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.homedepot.mm.po.allocationteamdata.entities.tldallocation.oracle.SkuCache;
import com.homedepot.mm.po.allocationteamdata.repository.tldallocation.oracle.SkuCacheRepository;
import com.homedepot.mm.po.allocationteamdata.services.SkuCacheService;

@Service("SkuCacheServiceImpl")
@Transactional("transactionManager")
public class SkuCacheServiceImpl implements SkuCacheService {

	@Autowired
	private SkuCacheRepository skuCacheRepository;

	@Override
	public SkuCache findSkuCache(String transloadDcNumber, Integer skuNumber) {
		return skuCacheRepository.findByTransloadDcNumberAndSkuNumber(transloadDcNumber, skuNumber);
	}

	@Override
	public SkuCache insertSkuCache(String transloadDcNumber, Integer skuNumber, String createProgramId) {

		SkuCache skuCache = new SkuCache();
		skuCache.setTransloadDcNumber(transloadDcNumber);
		skuCache.setSkuNumber(skuNumber);
		skuCache.setCreateProgramId(createProgramId);

		return skuCacheRepository.save(skuCache);
	}

}

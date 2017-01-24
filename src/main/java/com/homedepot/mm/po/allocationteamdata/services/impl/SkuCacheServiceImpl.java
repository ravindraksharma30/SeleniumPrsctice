package com.homedepot.mm.po.allocationteamdata.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homedepot.mm.po.allocationteamdata.entities.tldallocation.oracle.SkuCache;
import com.homedepot.mm.po.allocationteamdata.repository.tldallocation.oracle.SkuCacheRepository;
import com.homedepot.mm.po.allocationteamdata.services.SkuCacheService;

@Service("SkuCacheServiceImpl")
public class SkuCacheServiceImpl implements SkuCacheService {

	@Autowired
	private SkuCacheRepository skuCacheRepository;

	@Override
	public SkuCache getSkuCache(String transloadDcNumber, Integer skuNumber) {
		return skuCacheRepository.findByTransloadDcNumberAndSkuNumber(transloadDcNumber, skuNumber);
	}

	@Override
	public void setSkuCache(String transloadNumber, Integer skuNumber) {
		// TODO Auto-generated method stub

	}

}

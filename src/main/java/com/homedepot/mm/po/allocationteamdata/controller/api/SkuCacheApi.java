package com.homedepot.mm.po.allocationteamdata.controller.api;

import org.springframework.http.ResponseEntity;

import com.homedepot.mm.po.allocationteamdata.entities.tldallocation.oracle.SkuCache;
import com.homedepot.mm.po.allocationteamdata.exception.InvalidQueryParamException;

/**
 * 
 * @author gxk8870
 *
 */
public interface SkuCacheApi {

	public static final String SEARCH_PATH_GET = "/findSkuCache";
	public static final String SEARCH_PATH_PUT = "/insertSkuCache";

	/**
	 * Returns the cached record in the database.
	 * 
	 * @param transloadDcNumber
	 * @param skuNumber
	 * @return
	 * @throws InvalidQueryParamException
	 */
	public ResponseEntity<SkuCache> findSkuCache(final String transloadDcNumber, final Integer skuNumber)
			throws InvalidQueryParamException;

	/**
	 * Inserts a record to be cached into the database.
	 * 
	 * @param transloadDcNumber
	 * @param skuNumber
	 * @return
	 * @throws InvalidQueryParamException
	 */
	public ResponseEntity<String> insertSkuCache(final String transloadDcNumber, final Integer skuNumber,
			final String createProgramId) throws InvalidQueryParamException;
}

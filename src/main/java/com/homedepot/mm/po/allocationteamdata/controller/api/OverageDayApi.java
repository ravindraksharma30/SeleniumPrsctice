/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.controller.api;

import org.springframework.http.ResponseEntity;

import com.homedepot.mm.po.allocationteamdata.controller.OverageDayController;
import com.homedepot.mm.po.allocationteamdata.domain.OverageDayResource;
import com.homedepot.mm.po.allocationteamdata.exception.InvalidQueryParamException;
import com.homedepot.mm.po.allocationteamdata.services.OverageDaysService;

/**
 * Defines an API for {@link OverageDayController}. This is used to serve an
 * entry point for {@link OverageDaysService}.
 * 
 * @author axd8472
 *
 */
public interface OverageDayApi {
	/**
	 * 
	 */
	public static final String SEARCH_PATH = "/findOverageDays";

	/*
	 * 
	 */

	/**
	 * @see com.homedepot.mm.po.allocationteamdata.controller.OverageDay#findOverageDays()
	 * @param locationId
	 * @param skuNumber
	 * @param activeFlag
	 * @return
	 * @throws InvalidQueryParamException
	 */
	public ResponseEntity<OverageDayResource> findOverageDay(final String locationId, final String skuNumber,
			final String activeFlag) throws InvalidQueryParamException;

}

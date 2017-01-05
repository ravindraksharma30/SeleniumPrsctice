/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.controller.api;

import org.springframework.http.ResponseEntity;

import com.homedepot.mm.po.allocationteamdata.controller.OverageDaysController;
import com.homedepot.mm.po.allocationteamdata.exception.InvalidQueryParamException;
import com.homedepot.mm.po.allocationteamdata.response.OverageDaysResponse;
import com.homedepot.mm.po.allocationteamdata.services.OverageDaysService;

/**
 * Defines an API for {@link OverageDaysController}. This is used to serve an
 * entry point for {@link OverageDaysService}.
 * 
 * @author axd8472
 *
 */
public interface OverageDaysApi {
	/**
	 * 
	 */
	public static final String SEARCH_PATH = "/findOverageDays";

	/*
	 * 
	 */

	/**
	 * @see com.homedepot.mm.po.allocationteamdata.controller.OverageDays#findOverageDays()
	 * @param locationId
	 * @param skuNumber
	 * @param activeFlag
	 * @return
	 * @throws InvalidQueryParamException
	 */
	public ResponseEntity<OverageDaysResponse> findOverageDays(final String locationId, final String skuNumber,
			final String activeFlag) throws InvalidQueryParamException;

}

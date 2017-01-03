/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.controller.api;

import org.springframework.http.ResponseEntity;

import com.homedepot.mm.po.allocationteamdata.exception.InvalidQueryParamException;
import com.homedepot.mm.po.allocationteamdata.response.BayParmResponse;

/**
 * Defines an API for BayParmController. This is used to serve an entry point
 * for BayParm services.
 * 
 * @author axd8472
 *
 */
public interface BayParmApi {

	/**
	 * The path used to access the method getBayParm() of
	 * AllocationOnBoardController
	 */
	public static final String SEARCH_PATH = "/findBayParms";

	/**
	 * @see com.homedepot.mm.po.allocationteamdata.controller.BayParmController#findBayParms()
	 * @param locationId
	 * @param skuNumber
	 * @param activeFlag
	 * @return
	 * @throws InvalidQueryParamException
	 */
	public ResponseEntity<BayParmResponse> findBayParms(final String locationId, final String skuNumber,
			final String activeFlag) throws InvalidQueryParamException;
}

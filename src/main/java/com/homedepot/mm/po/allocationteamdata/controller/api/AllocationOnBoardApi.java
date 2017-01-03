/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.controller.api;

import org.springframework.http.ResponseEntity;

import com.homedepot.mm.po.allocationteamdata.exception.InvalidQueryParamException;
import com.homedepot.mm.po.allocationteamdata.response.AllocationOnBoardResponse;

/**
 * Defines an API for AllocationOnBoardController. This is used to serve an
 * entry point for AllocationOnBoard services.
 * 
 * @author axd8472
 *
 */
public interface AllocationOnBoardApi {

	/**
	 * The path used to access the method getBayParm() of
	 * AllocationOnBoardController
	 */
	public static final String SEARCH_PATH = "/findAllocationOnBoards";

	/**
	 * @see com.homedepot.mm.po.allocationteamdata.controller.AllocationOnBoardController#findAllocationOnBoards()
	 * @param parmTypeCode
	 * @return
	 * @throws InvalidQueryParamException
	 */

	public ResponseEntity<AllocationOnBoardResponse> findAllocationOnBoards(final Integer parmTypeCode)
			throws InvalidQueryParamException;
}

/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.homedepot.mm.po.allocationteamdata.controller.AllocationController;
import com.homedepot.mm.po.allocationteamdata.dto.TransloadSkuDTO;
import com.homedepot.mm.po.allocationteamdata.exception.ValidationException;

/**
 * Defines an API for {@link AllocationController}. This is used to serve an
 * entry point for performing allocations.
 * 
 * @author axd8472
 *
 */
public interface AllocationApi {

	/**
	 * The path used to access the method performAllocation() of
	 * AllocationController
	 */
	public static final String ALLOCATE_PATH = "/createAllocation";

	/**
	 * 
	 * @see com.homedepot.mm.po.allocationteamdata.controller.AllocationController#performAllocation()
	 *
	 * @param transloadSkuDTO
	 * @param result
	 * @return
	 * @throws ValidationException
	 */
	public ResponseEntity<String> performAllocation(final TransloadSkuDTO transloadSkuDTO, final BindingResult result)
			throws ValidationException;

}

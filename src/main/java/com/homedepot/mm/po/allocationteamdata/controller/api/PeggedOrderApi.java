/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.controller.api;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;

import com.homedepot.mm.po.allocationteamdata.domain.PeggedOrderResource;
import com.homedepot.mm.po.allocationteamdata.exception.InvalidQueryParamException;

/**
 * Defines an API for PeggedOrderController. This is used to serve an entry
 * point for PeggedOrder services.
 * 
 * @author axd8472
 *
 */
public interface PeggedOrderApi {

	/**
	 * 
	 */
	public static final String SEARCH_PATH = "/findPeggedOrder";

	/**
	 * @see com.homedepot.mm.po.allocationteamdata.controller.PeggedOrderController#findPeggedOrder()
	 * @param asnNumber
	 * @param poNumber
	 * @param skuNumber
	 * @return
	 * @throws InvalidQueryParamException
	 */

	public ResponseEntity<PeggedOrderResource> findPeggedOrder(final String asnNumber, final String poNumber,
			final BigDecimal skuNumber) throws InvalidQueryParamException;

}

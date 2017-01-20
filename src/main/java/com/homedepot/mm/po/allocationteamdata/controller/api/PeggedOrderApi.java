/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.controller.api;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;

import com.homedepot.mm.po.allocationteamdata.controller.PeggedOrderController;
import com.homedepot.mm.po.allocationteamdata.exception.InvalidQueryParamException;
import com.homedepot.mm.po.allocationteamdata.response.PeggedOrderResponse;
import com.homedepot.mm.po.allocationteamdata.services.PeggedOrderService;

/**
 * Defines an API for {@link PeggedOrderController}. This is used to serve an
 * entry point for {@link PeggedOrderService}.
 * 
 * @author axd8472
 *
 */
public interface PeggedOrderApi {

	/**
	 * 
	 */
	public static final String SEARCH_PATH = "/findPeggedOrders";

	/**
	 * @see com.homedepot.mm.po.allocationteamdata.controller.PeggedOrderController#findPeggedOrder()
	 * @param asnNumber
	 * @param poNumber
	 * @param skuNumber
	 * @return
	 * @throws InvalidQueryParamException
	 */

	public ResponseEntity<PeggedOrderResponse> findPeggedOrder(final String asnNumber, final String poNumber,
			final BigDecimal skuNumber) throws InvalidQueryParamException;

}

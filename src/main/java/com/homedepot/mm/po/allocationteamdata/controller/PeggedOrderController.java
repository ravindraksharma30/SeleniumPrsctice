/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.controller;

import java.math.BigDecimal;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homedepot.mm.po.allocationteamdata.assembler.PeggedOrderResourceAssembler;
import com.homedepot.mm.po.allocationteamdata.controller.api.PeggedOrderApi;
import com.homedepot.mm.po.allocationteamdata.domain.PeggedOrderResource;
import com.homedepot.mm.po.allocationteamdata.entities.oracle.PeggedOrder;
import com.homedepot.mm.po.allocationteamdata.exception.InvalidQueryParamException;
import com.homedepot.mm.po.allocationteamdata.response.PeggedOrderResponse;
import com.homedepot.mm.po.allocationteamdata.services.MessageByLocaleService;
import com.homedepot.mm.po.allocationteamdata.services.PeggedOrderService;
import com.homedepot.mm.po.allocationteamdata.util.StringUtils;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * PeggedOrderController utilizes the {@link PeggedOrderApi} interface to act as
 * a director for retrieving information from the {@link PeggedOrderService}.
 * 
 * @author axd8472
 *
 */
@RestController
public class PeggedOrderController implements PeggedOrderApi {
	/**
	 * Utilized in performing the SELECT operation for retrieving the data.
	 */
	@Autowired
	PeggedOrderService peggedOrderService;
	/**
	 * Utilized in converting the result dataset to a JSON representation.
	 */
	@Autowired
	PeggedOrderResourceAssembler peggedOrderResourceAssembler;
	/**
	 * Utilized in providing internationalization for message responses.
	 */
	@Autowired
	private MessageByLocaleService messageSource;

	/**
	 * 
	 * @see com.homedepot.mm.po.allocationteamdata.controller.api.PeggedOrderApi#
	 *      findPeggedOrder(java.lang.String, java.lang.String,
	 *      java.math.BigDecimal)
	 * 
	 * @param asnNumber
	 * @param poNumber
	 * @param skuNumber
	 * @return peggedOrderResponse
	 * 
	 */
	@Override
	@GetMapping(value = PeggedOrderApi.SEARCH_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Retrieve Pegging data based on ASN/PO combination", nickname = "Pegging")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "asnNumber", value = "ASN Number", required = false, dataType = "string", paramType = "query", defaultValue = "0"),
			@ApiImplicitParam(name = "poNumber", value = "PO Number", required = false, dataType = "string", paramType = "query", defaultValue = "0"),
			@ApiImplicitParam(name = "skuNumber", value = "SKU Number", required = false, dataType = "string", paramType = "query", defaultValue = "0") })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = PeggedOrderController.class),
			@ApiResponse(code = 403, message = "Forbidden"), @ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public ResponseEntity<PeggedOrderResponse> findPeggedOrder(@QueryParam("asnNumber") final String asnNumber,
			@QueryParam("poNumber") final String poNumber, @QueryParam("skuNumber") final BigDecimal skuNumber)
			throws InvalidQueryParamException {

		PeggedOrderResource peggedOrderResource = null;
		PeggedOrderResponse peggedOrderResponse = new PeggedOrderResponse();

		/*
		 * Validate Query parameters to make sure parameters are mandatorily
		 * present in the request in-order to retrieve values from database.
		 */
		if (StringUtils.isNullOrEmpty(asnNumber, poNumber) || null == skuNumber) {
			throw new InvalidQueryParamException(messageSource.getMessage("allocationteamdata.invalid.queryParameter"));
		}

		// Service call to perform database SELECT operation
		final PeggedOrder peggedOrder = peggedOrderService.findPeggedOrder(asnNumber, poNumber, skuNumber);

		// HATEOAS implementation
		if (null != peggedOrder) {
			peggedOrderResource = peggedOrderResourceAssembler.toResource(peggedOrder);
			peggedOrderResponse.setPeggedOrderResource(peggedOrderResource);

		}

		return new ResponseEntity<PeggedOrderResponse>(peggedOrderResponse, HttpStatus.OK);
	}

}

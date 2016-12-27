/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.controller;

import java.math.BigDecimal;

import javax.ws.rs.QueryParam;

import org.assertj.core.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homedepot.mm.po.allocationteamdata.assembler.PeggedOrderResourceAssembler;
import com.homedepot.mm.po.allocationteamdata.constants.AllocationTeamDataConstants;
import com.homedepot.mm.po.allocationteamdata.domain.PeggedOrderResource;
import com.homedepot.mm.po.allocationteamdata.entities.oracle.PeggedOrder;
import com.homedepot.mm.po.allocationteamdata.exception.InvalidQueryParamException;
import com.homedepot.mm.po.allocationteamdata.services.PeggedOrderService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

/**
 * @author axd8472
 *
 */
@RestController
@Slf4j
public class PeggedOrderController {

	@Autowired
	PeggedOrderService peggedOrderService;

	@Autowired
	PeggedOrderResourceAssembler peggedOrderResourceAssembler;

	/**
	 *
	 * @param asnNumber
	 * @param poNumber
	 * @param skuNumber
	 * @return
	 * @throws InvalidQueryParamException
	 */
	@GetMapping(value = "/findPeggedOrder", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Retrieve Pegging data based on ASN/PO combination", nickname = "Pegging")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "asnNumber", value = "ASN Number", required = false, dataType = "string", paramType = "query", defaultValue = "0"),
			@ApiImplicitParam(name = "poNumber", value = "PO Number", required = false, dataType = "string", paramType = "query", defaultValue = "0"),
			@ApiImplicitParam(name = "skuNumber", value = "SKU Number", required = false, dataType = "string", paramType = "query", defaultValue = "0") })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = PeggedOrderController.class),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	public ResponseEntity<PeggedOrderResource> findPeggedOrder(@QueryParam("asnNumber") String asnNumber,
			@QueryParam("poNumber") String poNumber, @QueryParam("skuNumber") BigDecimal skuNumber)
			throws InvalidQueryParamException {
		log.info("Inside findPeggedOrder");

		if (Strings.isNullOrEmpty(asnNumber) || Strings.isNullOrEmpty(poNumber) || null == skuNumber) {
			throw new InvalidQueryParamException(AllocationTeamDataConstants.INVALID_QUERY_PARAM_MSG);
		}
		PeggedOrderResource resources = null;

		final PeggedOrder peggedOrder = peggedOrderService.findPeggedOrder(asnNumber, poNumber, skuNumber);
		if (null != peggedOrder) {
			resources = peggedOrderResourceAssembler.toResource(peggedOrder);
		}
		log.info("Exiting findPeggedOrder");
		return new ResponseEntity<PeggedOrderResource>(resources, HttpStatus.OK);
	}

}

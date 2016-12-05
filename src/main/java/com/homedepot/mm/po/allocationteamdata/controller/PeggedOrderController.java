/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.controller;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homedepot.mm.po.allocationteamdata.assembler.PeggedOrderResourceAssembler;
import com.homedepot.mm.po.allocationteamdata.domain.PeggedOrderResource;
import com.homedepot.mm.po.allocationteamdata.entities.oracle.PeggedOrder;
import com.homedepot.mm.po.allocationteamdata.services.PeggedOrderService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author axd8472
 *
 */
@RestController
public class PeggedOrderController {

	@Autowired
	PeggedOrderService peggedOrderService;

	@Autowired
	PeggedOrderResourceAssembler peggedOrderResourceAssembler;

	@GetMapping(value = "/findPeggedOrders", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Retrieve Pegging data based on ASN/PO combination", nickname = "Pegging")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "asnNumber", value = "ASN Number", required = false, dataType = "string", paramType = "query", defaultValue = "0"),
			@ApiImplicitParam(name = "poNumber", value = "PO Number", required = false, dataType = "string", paramType = "query", defaultValue = "0") })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = BayParmController.class),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })

	/**
	 * 
	 * @param asnNumber
	 * @param poNumber
	 * @return
	 */
	public ResponseEntity<List<PeggedOrderResource>> findPeggedOrders(@QueryParam("asnNumber") String asnNumber,
			@QueryParam("poNumber") String poNumber) {

		final List<PeggedOrder> peggedOrders = peggedOrderService.findPeggedOrders(asnNumber, poNumber);
		final List<PeggedOrderResource> resources = peggedOrderResourceAssembler.toResources(peggedOrders);

		return new ResponseEntity<List<PeggedOrderResource>>(resources, HttpStatus.OK);
	}

}

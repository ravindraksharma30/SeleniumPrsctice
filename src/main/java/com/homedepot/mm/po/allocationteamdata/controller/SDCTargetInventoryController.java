package com.homedepot.mm.po.allocationteamdata.controller;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.assertj.core.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homedepot.mm.po.allocationteamdata.assembler.SDCTargetInventoryAssembler;
import com.homedepot.mm.po.allocationteamdata.constants.AllocationTeamDataConstants;
import com.homedepot.mm.po.allocationteamdata.domain.SDCTargetInventoryResource;
import com.homedepot.mm.po.allocationteamdata.entities.teradata.SDCTargetInventory;
import com.homedepot.mm.po.allocationteamdata.exception.InvalidQueryParamException;
import com.homedepot.mm.po.allocationteamdata.services.SDCTargetInventoryService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author axd8472 & @author svp5283
 *
 */
@Slf4j
@RestController

public class SDCTargetInventoryController {

	@Autowired
	SDCTargetInventoryService sdcTargetInventoryService;

	@Autowired
	SDCTargetInventoryAssembler sdcTargetInventoryAssembler;

	/**
	 *
	 * @param locationId
	 * @param skuNumber
	 * @param activeFlag
	 * @return
	 * @throws InvalidQueryParamException
	 */
	@GetMapping(value = "/findSDCTargetInventory", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Retrieve SDC target inventory based on location and activeflag", nickname = "SDCTargetInventory")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "locationId", value = "DC Location Id", required = false, dataType = "string", paramType = "query", defaultValue = "Smyrna"),
			@ApiImplicitParam(name = "skuNumber", value = "SKU Number", required = false, dataType = "string", paramType = "query", defaultValue = "100000"),
			@ApiImplicitParam(name = "activeFlag", value = "Active Flag", required = false, dataType = "string", paramType = "query", defaultValue = "Y") })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = SDCTargetInventoryController.class),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal server error") })
	public ResponseEntity<List<SDCTargetInventoryResource>> getSdcTargetInventory(
			@QueryParam("locationId") String locationId, @QueryParam("skuNumber") String skuNumber,
			@QueryParam("activeFlag") String activeFlag) throws InvalidQueryParamException {
		log.info("Inside getSdcTargetInventory");
		if (Strings.isNullOrEmpty(locationId) || Strings.isNullOrEmpty(skuNumber)
				|| Strings.isNullOrEmpty(activeFlag)) {
			throw new InvalidQueryParamException(AllocationTeamDataConstants.INVALID_QUERY_PARAM_MSG);
		}
		List<SDCTargetInventoryResource> resources = null;
		final List<SDCTargetInventory> sdcTargetInventories = sdcTargetInventoryService
				.getSDCTargetInventory(locationId, skuNumber, activeFlag);

		if (null != sdcTargetInventories && !sdcTargetInventories.isEmpty() && sdcTargetInventories.size() > 0) {
			resources = sdcTargetInventoryAssembler.toResources(sdcTargetInventories);
		}
		log.info("Exiting getSdcTargetInventory");
		return new ResponseEntity<List<SDCTargetInventoryResource>>(resources, HttpStatus.OK);
	}

}

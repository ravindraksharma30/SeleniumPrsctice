package com.homedepot.mm.po.allocationteamdata.controller;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homedepot.mm.po.allocationteamdata.assembler.SDCTargetInventoryAssembler;
import com.homedepot.mm.po.allocationteamdata.domain.SDCTargetInventoryResource;
import com.homedepot.mm.po.allocationteamdata.entities.SDCTargetInventory;
import com.homedepot.mm.po.allocationteamdata.exception.DataNotFoundException;
import com.homedepot.mm.po.allocationteamdata.services.SDCTargetInventoryService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 
 * @author axd8472 & @author svp5283
 *
 */
@RestController
public class SDCTargetInventoryController {

	@Autowired
	SDCTargetInventoryService sdcTargetInventoryService;

	@Autowired
	SDCTargetInventoryAssembler sdcTargetInventoryAssembler;

	@GetMapping(value = "/findSDCTargetInventory", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Retrieve SDC target inventory based on location and activeflag", nickname = "SDCTargetInventory")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "locationId", value = "DC Location Id", required = false, dataType = "string", paramType = "query", defaultValue = "Smyrna"),
			@ApiImplicitParam(name = "activeFlag", value = "Active Flag", required = false, dataType = "string", paramType = "query", defaultValue = "Y") })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = SDCTargetInventoryController.class),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal server error"),
			@ApiResponse(code = 700, message = "Data Not Found") })
	/**
	 * 
	 * @param lacationId
	 * @param activeFlag
	 * @return
	 * @throws DataNotFoundException
	 */
	public ResponseEntity<List<SDCTargetInventoryResource>> getSdcTargetInventory(
			@QueryParam("locationId") String locationId, @QueryParam("activeFlag") String activeFlag)
			throws DataNotFoundException {
		final List<SDCTargetInventory> sdcTargetInventories = sdcTargetInventoryService
				.getSDCTargetInventory(locationId, activeFlag);
		final List<SDCTargetInventoryResource> resources = sdcTargetInventoryAssembler
				.toResources(sdcTargetInventories);

		return new ResponseEntity<List<SDCTargetInventoryResource>>(resources, HttpStatus.OK);
	}

}

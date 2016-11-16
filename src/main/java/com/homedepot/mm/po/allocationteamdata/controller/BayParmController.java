package com.homedepot.mm.po.allocationteamdata.controller;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homedepot.mm.po.allocationteamdata.assembler.BayParmResourceAssembler;
import com.homedepot.mm.po.allocationteamdata.domain.BayParmResource;
import com.homedepot.mm.po.allocationteamdata.entities.teradata.BayParm;
import com.homedepot.mm.po.allocationteamdata.exception.DataNotFoundException;
import com.homedepot.mm.po.allocationteamdata.services.BayParmService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 
 * @author axd8472 & @author spv5283
 *
 */
@RestController
public class BayParmController {

	@Autowired
	BayParmService bayParmService;

	@Autowired
	BayParmResourceAssembler bayParmResourceAssembler;

	@GetMapping(value = "/findBayParm", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Retrieve BayParmEntityDTO based on location and activeflag", nickname = "BayParmEntityDTO")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "locationId", value = "DC Location Id", required = false, dataType = "string", paramType = "query", defaultValue = "Smyrna"),
			@ApiImplicitParam(name = "activeFlag", value = "Active Flag", required = false, dataType = "string", paramType = "query", defaultValue = "Y") })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = BayParmController.class),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })

	/**
	 * 
	 * @param locationId
	 * @param activeFlag
	 * @return
	 * @throws DataNotFoundException
	 */
	public ResponseEntity<List<BayParmResource>> getBayParm(@QueryParam("locationId") String locationId,
			@QueryParam("activeFlag") String activeFlag) throws DataNotFoundException {

		final List<BayParm> bayParms = bayParmService.getBayParm(locationId, activeFlag);
		final List<BayParmResource> resources = bayParmResourceAssembler.toResources(bayParms);

		return new ResponseEntity<List<BayParmResource>>(resources, HttpStatus.OK);
	}

}

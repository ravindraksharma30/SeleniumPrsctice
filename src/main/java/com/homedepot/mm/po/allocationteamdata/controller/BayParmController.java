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

import com.homedepot.mm.po.allocationteamdata.assembler.BayParmResourceAssembler;
import com.homedepot.mm.po.allocationteamdata.constants.AllocationTeamDataConstants;
import com.homedepot.mm.po.allocationteamdata.domain.BayParmResource;
import com.homedepot.mm.po.allocationteamdata.entities.teradata.BayParm;
import com.homedepot.mm.po.allocationteamdata.exception.InvalidQueryParamException;
import com.homedepot.mm.po.allocationteamdata.services.BayParmService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author axd8472 & @author spv5283
 *
 */
@RestController
@Slf4j
public class BayParmController {

	@Autowired
	BayParmService bayParmService;

	@Autowired
	BayParmResourceAssembler bayParmResourceAssembler;

	/**
	 * 
	 * @param locationId
	 * @param skuNumber
	 * @param activeFlag
	 * @return
	 * @throws InvalidQueryParamException
	 */
	@GetMapping(value = "/findBayParm", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Retrieve BayParm based on location and activeflag", nickname = "BayParm")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "locationId", value = "DC Location Id", required = false, dataType = "string", paramType = "query", defaultValue = "Smyrna"),
			@ApiImplicitParam(name = "skuNumber", value = "SKU Number", required = false, dataType = "string", paramType = "query", defaultValue = "100000"),
			@ApiImplicitParam(name = "activeFlag", value = "Active Flag", required = false, dataType = "string", paramType = "query", defaultValue = "Y") })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = BayParmController.class),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	public ResponseEntity<List<BayParmResource>> getBayParm(@QueryParam("locationId") String locationId,
			@QueryParam("skuNumber") String skuNumber, @QueryParam("activeFlag") String activeFlag)
			throws InvalidQueryParamException {
		log.info("Inside getBayParm");

		if (Strings.isNullOrEmpty(locationId) || Strings.isNullOrEmpty(skuNumber)
				|| Strings.isNullOrEmpty(activeFlag)) {
			throw new InvalidQueryParamException(AllocationTeamDataConstants.INVALID_QUERY_PARAM_MSG);
		}
		List<BayParmResource> resources = null;
		final List<BayParm> bayParms = bayParmService.getBayParm(locationId, skuNumber, activeFlag);
		if (null != bayParms && !bayParms.isEmpty() && bayParms.size() > 0) {
			resources = bayParmResourceAssembler.toResources(bayParms);
		}

		log.info("Exiting getBayParm");
		return new ResponseEntity<List<BayParmResource>>(resources, HttpStatus.OK);

	}

}

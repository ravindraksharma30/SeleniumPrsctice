package com.homedepot.mm.po.allocationteamdata.controller;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homedepot.mm.po.allocationteamdata.assembler.BayParmResourceAssembler;
import com.homedepot.mm.po.allocationteamdata.constants.AllocationTeamDataConstants;
import com.homedepot.mm.po.allocationteamdata.controller.api.BayParmApi;
import com.homedepot.mm.po.allocationteamdata.domain.BayParmResource;
import com.homedepot.mm.po.allocationteamdata.entities.teradata.BayParm;
import com.homedepot.mm.po.allocationteamdata.exception.InvalidQueryParamException;
import com.homedepot.mm.po.allocationteamdata.services.BayParmService;
import com.homedepot.mm.po.allocationteamdata.services.MessageByLocaleService;
import com.homedepot.mm.po.allocationteamdata.util.StringUtils;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * BayParmController utilizes the {@link BayParmApi} interface to act as a
 * director for retrieving information from the {@link BayParmService}.
 * 
 * @author axd8472 & @author spv5283
 *
 */
@RestController
public class BayParmController implements BayParmApi {
	/**
	 * Utilized in performing the SELECT operation for retrieving the data.
	 */
	@Autowired
	private BayParmService bayParmService;
	/**
	 * Utilized in converting the result dataset to a JSON representation.
	 */
	@Autowired
	private BayParmResourceAssembler bayParmResourceAssembler;

	/**
	 * Utilized in providing internationalization for message responses.
	 */
	@Autowired
	private MessageByLocaleService messageSource;

	/**
	 * 
	 * @see com.homedepot.mm.po.allocationteamdata.controller.api.BayParmApi#
	 *      findBayParms(java.lang.String, java.lang.String, java.lang.String)
	 * 
	 * @param locationId
	 * @param skuNumber
	 * @param activeFlag
	 * @return bayParmResponse
	 */
	@Override
	@GetMapping(value = BayParmApi.SEARCH_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Retrieve BayParm based on location and activeflag", nickname = "BayParm")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "locationId", value = "DC Location Id", required = false, dataType = "string", paramType = "query", defaultValue = "Smyrna"),
			@ApiImplicitParam(name = "skuNumber", value = "SKU Number", required = false, dataType = "string", paramType = "query", defaultValue = "100000"),
			@ApiImplicitParam(name = "activeFlag", value = "Active Flag", required = false, dataType = "string", paramType = "query", defaultValue = "Y") })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = BayParmController.class),
			@ApiResponse(code = 403, message = "Forbidden"), @ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public ResponseEntity<BayParmResource> findBayParm(@QueryParam("locationId") final String locationId,
			@QueryParam("skuNumber") final String skuNumber, @QueryParam("activeFlag") final String activeFlag)
			throws InvalidQueryParamException {

		BayParmResource bayParmResource = new BayParmResource();

		/*
		 * Validate Query parameters to make sure parameters are mandatorily
		 * present in the request in-order to retrieve values from database.
		 */
		if (StringUtils.isNullOrEmpty(locationId, skuNumber, activeFlag)) {
			throw new InvalidQueryParamException(
					messageSource.getMessage(AllocationTeamDataConstants.ERROR_INVALID_QUERY));
		}

		// Service call to perform database SELECT operation
		final BayParm bayParm = bayParmService.findBayParm(locationId, skuNumber, activeFlag);

		// HATEOAS implementation
		if (bayParm != null) {
			bayParmResource = bayParmResourceAssembler.toResource(bayParm);
		}

		return new ResponseEntity<BayParmResource>(bayParmResource, HttpStatus.OK);

	}

}

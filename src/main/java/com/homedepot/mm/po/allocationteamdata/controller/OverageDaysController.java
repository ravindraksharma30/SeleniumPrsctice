package com.homedepot.mm.po.allocationteamdata.controller;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homedepot.mm.po.allocationteamdata.assembler.OverageDaysResourceAssembler;
import com.homedepot.mm.po.allocationteamdata.controller.api.OverageDaysApi;
import com.homedepot.mm.po.allocationteamdata.domain.OverageDaysResource;
import com.homedepot.mm.po.allocationteamdata.entities.teradata.OverageDays;
import com.homedepot.mm.po.allocationteamdata.exception.InvalidQueryParamException;
import com.homedepot.mm.po.allocationteamdata.services.MessageByLocaleService;
import com.homedepot.mm.po.allocationteamdata.services.OverageDaysService;
import com.homedepot.mm.po.allocationteamdata.util.StringUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 
 * @author axd8472
 *
 */
@RestController
public class OverageDaysController implements OverageDaysApi {
	/**
	 * 
	 */
	@Autowired
	private OverageDaysService overageDaysService;
	/**
	 * 
	 */
	@Autowired
	private OverageDaysResourceAssembler overageDaysResourceAssembler;
	/**
	 * 
	 */
	@Autowired
	private MessageByLocaleService messageSource;

	/**
	 *
	 * @param locationId
	 * @param skuNumber
	 * @param activeFlag
	 * @return
	 * @throws InvalidQueryParamException
	 */
	@Override
	@GetMapping(value = OverageDaysApi.SEARCH_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Retrieve Overage Days based on location and activeflag", nickname = "OverageDays")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "locationId", value = "DC Location Id", required = false, dataType = "string", paramType = "query", defaultValue = "Smyrna"),
			@ApiImplicitParam(name = "skuNumber", value = "SKU Number", required = false, dataType = "string", paramType = "query", defaultValue = "100000"),
			@ApiImplicitParam(name = "activeFlag", value = "Active Flag", required = false, dataType = "string", paramType = "query", defaultValue = "Y") })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = BayParmController.class),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	public ResponseEntity<List<OverageDaysResource>> findOverageDays(@QueryParam("locationId") final String locationId,
			@QueryParam("skuNumber") final String skuNumber, @QueryParam("activeFlag") final String activeFlag)
			throws InvalidQueryParamException {
		List<OverageDaysResource> resources = null;

		/*
		 * Validate Query parameters to make sure parameters are mandatorily
		 * present in the request in-order to retrieve values from database.
		 */
		if (StringUtil.isNullOrEmpty(locationId, skuNumber, activeFlag)) {
			throw new InvalidQueryParamException(
					messageSource.getMessage("allocationteamdata.invalid.query.parameter"));
		}

		// Service call to perform database SELECT operation
		final List<OverageDays> overageDays = overageDaysService.findOverageDays(locationId, skuNumber, activeFlag);

		// HATEOAS implementation
		if (null != overageDays && !overageDays.isEmpty() && overageDays.size() > 0) {
			resources = overageDaysResourceAssembler.toResources(overageDays);
		}

		return new ResponseEntity<List<OverageDaysResource>>(resources, HttpStatus.OK);
	}
}

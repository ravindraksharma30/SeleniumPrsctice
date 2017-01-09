package com.homedepot.mm.po.allocationteamdata.controller;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homedepot.mm.po.allocationteamdata.assembler.OverageDayResourceAssembler;
import com.homedepot.mm.po.allocationteamdata.constants.AllocationTeamDataConstants;
import com.homedepot.mm.po.allocationteamdata.controller.api.OverageDayApi;
import com.homedepot.mm.po.allocationteamdata.domain.OverageDayResource;
import com.homedepot.mm.po.allocationteamdata.entities.teradata.OverageDay;
import com.homedepot.mm.po.allocationteamdata.exception.InvalidQueryParamException;
import com.homedepot.mm.po.allocationteamdata.services.MessageByLocaleService;
import com.homedepot.mm.po.allocationteamdata.services.OverageDaysService;
import com.homedepot.mm.po.allocationteamdata.util.StringUtils;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * OverageDaysController utilizes the {@link OverageDayApi} interface to act as
 * a director for retrieving information from the {@link OverageDaysService}.
 * 
 * @author axd8472
 *
 */
@RestController
public class OverageDayController implements OverageDayApi {
	/**
	 * Utilized in performing the SELECT operation for retrieving the data.
	 */
	@Autowired
	private OverageDaysService overageDaysService;
	/**
	 * Utilized in converting the result dataset to a JSON representation.
	 */
	@Autowired
	private OverageDayResourceAssembler overageDaysResourceAssembler;
	/**
	 * Utilized in providing internationalization for message responses.
	 */
	@Autowired
	private MessageByLocaleService messageSource;

	/**
	 * 
	 * @see com.homedepot.mm.po.allocationteamdata.controller.api.OverageDayApi#
	 *      findOverageDays(java.lang.String, java.lang.String,
	 *      java.lang.String)
	 * 
	 * @param locationId
	 * @param skuNumber
	 * @param activeFlag
	 * @return
	 * @throws InvalidQueryParamException
	 */
	@Override
	@GetMapping(value = OverageDayApi.SEARCH_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Retrieve Overage Days based on location and activeflag", nickname = "OverageDays")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "locationId", value = "DC Location Id", required = false, dataType = "string", paramType = "query", defaultValue = "Smyrna"),
			@ApiImplicitParam(name = "skuNumber", value = "SKU Number", required = false, dataType = "string", paramType = "query", defaultValue = "100000"),
			@ApiImplicitParam(name = "activeFlag", value = "Active Flag", required = false, dataType = "string", paramType = "query", defaultValue = "Y") })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = BayParmController.class),
			@ApiResponse(code = 403, message = "Forbidden"), @ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public ResponseEntity<OverageDayResource> findOverageDay(@QueryParam("locationId") final String locationId,
			@QueryParam("skuNumber") final String skuNumber, @QueryParam("activeFlag") final String activeFlag)
			throws InvalidQueryParamException {
		OverageDayResource overageDayResource = new OverageDayResource();

		/*
		 * Validate Query parameters to make sure parameters are mandatorily
		 * present in the request in-order to retrieve values from database.
		 */
		if (StringUtils.isNullOrEmpty(locationId, skuNumber, activeFlag)) {
			throw new InvalidQueryParamException(
					messageSource.getMessage(AllocationTeamDataConstants.ERROR_INVALID_QUERY));
		}

		// Service call to perform database SELECT operation
		final OverageDay overageDay = overageDaysService.findOverageDay(locationId, skuNumber, activeFlag);

		// HATEOAS implementation
		if (null != overageDay) {
			overageDayResource = overageDaysResourceAssembler.toResource(overageDay);
		}

		return new ResponseEntity<OverageDayResource>(overageDayResource, HttpStatus.OK);
	}
}

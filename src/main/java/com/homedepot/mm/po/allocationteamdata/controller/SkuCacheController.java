package com.homedepot.mm.po.allocationteamdata.controller;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homedepot.mm.po.allocationteamdata.constants.AllocationTeamDataConstants;
import com.homedepot.mm.po.allocationteamdata.controller.api.SkuCacheApi;
import com.homedepot.mm.po.allocationteamdata.entities.tldallocation.oracle.SkuCache;
import com.homedepot.mm.po.allocationteamdata.exception.InvalidQueryParamException;
import com.homedepot.mm.po.allocationteamdata.services.MessageByLocaleService;
import com.homedepot.mm.po.allocationteamdata.services.SkuCacheService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class SkuCacheController implements SkuCacheApi {

	@Autowired
	private SkuCacheService skuCacheService;

	@Autowired
	private MessageByLocaleService messageSource;

	/**
	 * 
	 */
	@Override
	@GetMapping(value = SkuCacheApi.SEARCH_PATH_GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Retrieve SkuCache based on transload dc number and sku number", nickname = "SkuCacheGet")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "transloadDcNumber", value = "Transload DC Number", required = false, dataType = "string", paramType = "query", defaultValue = "0"),
			@ApiImplicitParam(name = "skuNumber", value = "SKU Number", required = false, dataType = "Integer", paramType = "query", defaultValue = "0") })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = BayParmController.class),
			@ApiResponse(code = 403, message = "Forbidden"), @ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public ResponseEntity<SkuCache> findSkuCache(@QueryParam("transloadDcNumber") final String transloadDcNumber,
			@QueryParam("skuNumber") final Integer skuNumber) throws InvalidQueryParamException {

		if (null == skuNumber || transloadDcNumber.isEmpty()) {
			throw new InvalidQueryParamException(
					messageSource.getMessage(AllocationTeamDataConstants.ERROR_INVALID_QUERY));
		}

		final SkuCache skuCache = skuCacheService.findSkuCache(transloadDcNumber, skuNumber);

		return new ResponseEntity<SkuCache>(skuCache, HttpStatus.OK);

	}

	@Override
	@GetMapping(value = SkuCacheApi.SEARCH_PATH_PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Inserts SkuCache based on transload dc number and sku number", nickname = "SkuCachePut")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "transloadDcNumber", value = "Transload DC Number", required = false, dataType = "string", paramType = "query", defaultValue = "0"),
			@ApiImplicitParam(name = "skuNumber", value = "SKU Number", required = false, dataType = "Integer", paramType = "query", defaultValue = "0"),
			@ApiImplicitParam(name = "createProgramId", value = "SKU Number", required = false, dataType = "String", paramType = "query", defaultValue = "0") })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = BayParmController.class),
			@ApiResponse(code = 403, message = "Forbidden"), @ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public ResponseEntity<String> insertSkuCache(@QueryParam("transloadDcNumber") final String transloadDcNumber,
			@QueryParam("skuNumber") final Integer skuNumber,
			@QueryParam("createProgramId") final String createProgramId) throws InvalidQueryParamException {

		if (null == skuNumber || transloadDcNumber.isEmpty()) {
			throw new InvalidQueryParamException(
					messageSource.getMessage(AllocationTeamDataConstants.ERROR_INVALID_QUERY));
		}

		skuCacheService.insertSkuCache(transloadDcNumber, skuNumber, createProgramId);

		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}
}

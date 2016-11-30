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
import com.homedepot.mm.po.allocationteamdata.domain.OverageDaysResource;
import com.homedepot.mm.po.allocationteamdata.entities.teradata.OverageDays;
import com.homedepot.mm.po.allocationteamdata.services.OverageDaysService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class OverageDaysController {

	@Autowired
	OverageDaysService overageDaysService;

	@Autowired
	OverageDaysResourceAssembler overageDaysResourceAssembler;

	@GetMapping(value = "/findOverageDays", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Retrieve Overage Days based on location and activeflag", nickname = "OverageDays")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "locationId", value = "DC Location Id", required = false, dataType = "string", paramType = "query", defaultValue = "Smyrna"),
			@ApiImplicitParam(name = "activeFlag", value = "Active Flag", required = false, dataType = "string", paramType = "query", defaultValue = "Y") })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = BayParmController.class),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })

	public ResponseEntity<List<OverageDaysResource>> getOverageDays(@QueryParam("locationId") String locationId,
			@QueryParam("activeFlag") String activeFlag) {

		final List<OverageDays> overageDays = overageDaysService.getOverageDays(locationId, activeFlag);
		final List<OverageDaysResource> resources = overageDaysResourceAssembler.toResources(overageDays);

		return new ResponseEntity<List<OverageDaysResource>>(resources, HttpStatus.OK);
	}
}

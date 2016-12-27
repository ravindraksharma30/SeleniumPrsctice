package com.homedepot.mm.po.allocationteamdata.controller;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homedepot.mm.po.allocationteamdata.assembler.AllocationOnBoardAssembler;
import com.homedepot.mm.po.allocationteamdata.constants.AllocationTeamDataConstants;
import com.homedepot.mm.po.allocationteamdata.domain.AllocationOnBoardResource;
import com.homedepot.mm.po.allocationteamdata.entities.teradata.AllocationOnBoard;
import com.homedepot.mm.po.allocationteamdata.exception.InvalidQueryParamException;
import com.homedepot.mm.po.allocationteamdata.services.AllocationOnBoardService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author rjc03
 *
 */
@RestController
@Slf4j
public class AllocationOnBoardController {

	@Autowired
	AllocationOnBoardService allocationOnBoardService;

	@Autowired
	AllocationOnBoardAssembler allocationOnBoardAssembler;

	/**
	 *
	 * @param parmTypeCode
	 * @return
	 * @throws InvalidQueryParamException
	 */
	@GetMapping(value = "/findAllocationOnBoard", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Retrieve System Parm and Transload ETA Days based on parmTypeCode", nickname = "AllocationOnBoard")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "parmTypeCode", value = "Parm TypeCode", required = false, dataType = "string", paramType = "query", defaultValue = "1") })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = BayParmController.class),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	public ResponseEntity<List<AllocationOnBoardResource>> getBayParm(
			@QueryParam("parmTypeCode") Integer parmTypeCode) throws InvalidQueryParamException {
		log.info("Inside getBayParm");

		if (null == parmTypeCode){

			throw new InvalidQueryParamException(AllocationTeamDataConstants.INVALID_QUERY_PARAM_MSG);
		}

		List<AllocationOnBoardResource> resources = null;
		final List<AllocationOnBoard> allocationOnBoards = allocationOnBoardService.getAllocationOnBoard(parmTypeCode);
		if (null != allocationOnBoards && !allocationOnBoards.isEmpty() && allocationOnBoards.size() > 0) {
			resources = allocationOnBoardAssembler.toResources(allocationOnBoards);
		}

		return new ResponseEntity<List<AllocationOnBoardResource>>(resources, HttpStatus.OK);
	}
}

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
import com.homedepot.mm.po.allocationteamdata.controller.api.AllocationOnBoardApi;
import com.homedepot.mm.po.allocationteamdata.entities.teradata.AllocationOnBoard;
import com.homedepot.mm.po.allocationteamdata.exception.InvalidQueryParamException;
import com.homedepot.mm.po.allocationteamdata.response.AllocationOnBoardResponse;
import com.homedepot.mm.po.allocationteamdata.services.AllocationOnBoardService;
import com.homedepot.mm.po.allocationteamdata.services.MessageByLocaleService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 
 * @author rjc03
 *
 */
@RestController
public class AllocationOnBoardController implements AllocationOnBoardApi {
	/**
	 * 
	 */
	@Autowired
	private AllocationOnBoardService allocationOnBoardService;
	/**
	 * 
	 */
	@Autowired
	private AllocationOnBoardAssembler allocationOnBoardAssembler;

	/**
	 * 
	 */
	@Autowired
	private MessageByLocaleService messageSource;

	/**
	 *
	 * @param parmTypeCode
	 * @return
	 * @throws InvalidQueryParamException
	 */
	@Override
	@GetMapping(value = AllocationOnBoardApi.SEARCH_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Retrieve System Parm and Transload ETA Days based on parmTypeCode", nickname = "AllocationOnBoard")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "parmTypeCode", value = "Parm TypeCode", required = false, dataType = "string", paramType = "query", defaultValue = "1") })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = BayParmController.class),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	public ResponseEntity<AllocationOnBoardResponse> findAllocationOnBoards(
			@QueryParam("parmTypeCode") final Integer parmTypeCode) throws InvalidQueryParamException {

		AllocationOnBoardResponse allocationOnBoardResponse = new AllocationOnBoardResponse();

		/*
		 * Validate Query parameter to make sure parmTypeCode is mandatory
		 * in-order to retrieve values from database.
		 */
		if (null == parmTypeCode) {

			throw new InvalidQueryParamException(
					messageSource.getMessage("allocationteamdata.invalid.query.parameter"));
		}

		// Service call to perform database SELECT operation
		final List<AllocationOnBoard> allocationOnBoards = allocationOnBoardService
				.findAllocationOnBoards(parmTypeCode);

		// HATEOAS implementation
		if (null != allocationOnBoards && !allocationOnBoards.isEmpty() && allocationOnBoards.size() > 0) {
			allocationOnBoardResponse = allocationOnBoardAssembler.toResources(allocationOnBoards);
		}

		return new ResponseEntity<AllocationOnBoardResponse>(allocationOnBoardResponse, HttpStatus.OK);
	}
}

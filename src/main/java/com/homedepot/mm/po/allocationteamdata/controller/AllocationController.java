package com.homedepot.mm.po.allocationteamdata.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homedepot.mm.po.allocationteamdata.controller.api.AllocationApi;
import com.homedepot.mm.po.allocationteamdata.dto.TransloadSkuDTO;
import com.homedepot.mm.po.allocationteamdata.exception.ValidationException;
import com.homedepot.mm.po.allocationteamdata.services.AllocationService;
import com.homedepot.mm.po.allocationteamdata.validator.AllocationValidator;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author axd8472
 *
 */
@RestController
public class AllocationController implements AllocationApi {

	/**
	 * 
	 */
	@Autowired
	private AllocationService allocationService;
	/**
	 * 
	 */
	@Autowired
	private AllocationValidator allocationValidator;

	/**
	 * 
	 * @param binder
	 */
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(allocationValidator);
	}

	/**
	 * 
	 * @param transloadSkuDTO
	 * @return
	 * @throws ValidationException
	 */
	@Override
	@PostMapping(value = AllocationApi.ALLOCATE_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Create Allocations based on TransloadSkuDTO", nickname = "Allocation")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "TransloadSkuDTO", value = "ASN Number", required = false, dataType = "TransloadSkuDTO") })
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created", response = PeggedOrderController.class),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	public ResponseEntity<String> performAllocation(@Valid TransloadSkuDTO transloadSkuDTO, BindingResult result)
			throws ValidationException {
		allocationValidator.validate(transloadSkuDTO, result);
		if (result.hasErrors()) {

			throw new ValidationException(result);

		}

		allocationService.createAllocation(transloadSkuDTO);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

}

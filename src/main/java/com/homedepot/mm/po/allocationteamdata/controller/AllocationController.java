/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.homedepot.mm.po.allocationteamdata.dto.ErrorDTO;
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
public class AllocationController {

	@Autowired
	private AllocationService allocationService;

	@Autowired
	private AllocationValidator allocationValidator;

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
	@PostMapping(value = "/createAllocation", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Create Allocations based on TransloadSkuDTO", nickname = "Allocation")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "asnNumber", value = "ASN Number", required = false, dataType = "string", paramType = "query", defaultValue = "0") })
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created", response = PeggedOrderController.class),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	public ResponseEntity<?> createAllocation(@Valid TransloadSkuDTO transloadSkuDTO, BindingResult result)
			throws ValidationException {
		if (result.hasErrors()) {

			throw new ValidationException();

		}

		allocationService.createAllocation(transloadSkuDTO);
		return ResponseEntity.noContent().build();
	}

	@ExceptionHandler(value = ValidationException.class)
	@ResponseBody
	public ResponseEntity<List<ErrorDTO>> validateException(ValidationException exception, BindingResult result)
			throws IOException {
		List<ErrorDTO> errors = new ArrayList<>();

		for (FieldError error : result.getFieldErrors()) {
			ErrorDTO errorDTO = new ErrorDTO();
			errorDTO.setMessage(error.getCode());
			errorDTO.setStatusCode(HttpStatus.BAD_REQUEST);
			errors.add(errorDTO);
		}
		return new ResponseEntity<List<ErrorDTO>>(errors, HttpStatus.BAD_REQUEST);

	}
}

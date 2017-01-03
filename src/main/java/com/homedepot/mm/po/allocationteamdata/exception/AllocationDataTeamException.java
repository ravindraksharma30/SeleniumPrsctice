/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.exception;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.homedepot.mm.po.allocationteamdata.dto.ErrorDTO;
import com.homedepot.mm.po.allocationteamdata.response.ErrorResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * AllocationDataTeamException is used to handle application specific exceptions
 * 
 * @author axd8472 & @author spv5283
 *
 */

@ControllerAdvice
@Slf4j
public class AllocationDataTeamException {

	/**
	 * 
	 * @param request
	 * @param exception
	 * @param result
	 * @return
	 * @throws IOException
	 */
	@ExceptionHandler(value = ValidationException.class)
	@ResponseBody
	public ResponseEntity<ErrorResponse> validateException(HttpServletRequest request, ValidationException exception,
			BindingResult result) throws IOException {
		ErrorResponse errorResponse = new ErrorResponse();
		List<ErrorDTO> errors = new ArrayList<>();

		for (FieldError error : result.getFieldErrors()) {
			ErrorDTO errorDTO = new ErrorDTO();
			errorDTO.setMessage(error.getCode());
			errorDTO.setStatus(HttpStatus.BAD_REQUEST.value());
			errors.add(errorDTO);
		}
		errorResponse.setErrors(errors);
		log.error("Exception Messgae:" + exception.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);

	}

	/**
	 * 
	 * @param request
	 * @param exception
	 * @return
	 * @throws IOException
	 */
	@ExceptionHandler(value = InvalidQueryParamException.class)
	@ResponseBody
	public ResponseEntity<ErrorResponse> validateQueryParamException(final HttpServletRequest request,
			final InvalidQueryParamException exception) throws IOException {
		ErrorResponse errorResponse = new ErrorResponse();
		final ErrorDTO errorDTO = new ErrorDTO(exception.getMessage(), HttpStatus.BAD_REQUEST,
				request.getRequestURI().toString(), HttpStatus.BAD_REQUEST.value(),
				InvalidQueryParamException.class.getName());
		errorResponse.setError(errorDTO);
		log.error("Exception Messgae:" + exception.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);

	}

}

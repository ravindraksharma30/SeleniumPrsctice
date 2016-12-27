/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.exception;

import com.homedepot.mm.po.allocationteamdata.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * AllocationDataTeamException is used to handle application specific exceptions
 * 
 * @author axd8472 & @author spv5283
 *
 */

@ControllerAdvice
public class AllocationDataTeamException {

	@ExceptionHandler(value = ValidationException.class)
	@ResponseBody
	public ResponseEntity<List<ErrorDTO>> validateException(HttpServletRequest req, ValidationException exception,
			BindingResult result) throws IOException {
		List<ErrorDTO> errors = new ArrayList<>();

		for (FieldError error : result.getFieldErrors()) {
			ErrorDTO errorDTO = new ErrorDTO();
			errorDTO.setMessage(error.getCode());
			errorDTO.setStatus(HttpStatus.BAD_REQUEST.value());
			errors.add(errorDTO);
		}
		return new ResponseEntity<List<ErrorDTO>>(errors, HttpStatus.BAD_REQUEST);

	}


	@ExceptionHandler(value = InvalidQueryParamException.class)
	@ResponseBody
	public ResponseEntity<ErrorDTO> validateQueryParamException(HttpServletRequest request, InvalidQueryParamException exception) throws IOException {
		ErrorDTO errorDTO = new ErrorDTO();
		errorDTO.setMessage(exception.getMessage());
		errorDTO.setStatus(HttpStatus.BAD_REQUEST.value());
		errorDTO.setError(HttpStatus.BAD_REQUEST);
		errorDTO.setException(InvalidQueryParamException.class.getName());
		errorDTO.setPath(request.getRequestURI().toString());
		return new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.BAD_REQUEST);

	}

}

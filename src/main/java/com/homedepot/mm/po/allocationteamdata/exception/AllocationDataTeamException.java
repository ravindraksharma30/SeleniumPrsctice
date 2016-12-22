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
import org.springframework.web.bind.annotation.RestController;

import com.homedepot.mm.po.allocationteamdata.dto.ErrorDTO;

/**
 * AllocationDataTeamException is used to handle application specific exceptions
 * 
 * @author axd8472 & @author spv5283
 *
 */

@ControllerAdvice(annotations = RestController.class)
public class AllocationDataTeamException {

	@ExceptionHandler(value = ValidationException.class)
	@ResponseBody
	public ResponseEntity<List<ErrorDTO>> validateException(HttpServletRequest req, ValidationException exception,
			BindingResult result) throws IOException {
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

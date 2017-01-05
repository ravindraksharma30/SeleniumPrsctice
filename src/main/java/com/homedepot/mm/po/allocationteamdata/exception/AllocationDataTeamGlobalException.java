/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.homedepot.mm.po.allocationteamdata.dto.ErrorDTO;
import com.homedepot.mm.po.allocationteamdata.response.ErrorResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * AllocationDataTeamGlobalException is used to handle global/generic exceptions
 * 
 * @author axd8472 & @author spv5283
 *
 */
@ControllerAdvice
@Slf4j
public class AllocationDataTeamGlobalException {

	/**
	 * 
	 * @param request
	 * @param exception
	 * @return
	 * @throws IOException
	 */
	@ExceptionHandler(value = NullPointerException.class)
	@ResponseBody
	public ResponseEntity<ErrorResponse> handleNullPointerException(final HttpServletRequest request,
			final NullPointerException exception) throws IOException {
		ErrorResponse errorResponse = new ErrorResponse();
		final ErrorDTO errorDTO = new ErrorDTO(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,
				request.getRequestURI().toString(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
				NullPointerException.class.getName());
		errorResponse.setError(errorDTO);
		log.error("Exception Messgae:" + exception.getMessage());
		exception.printStackTrace();
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	/**
	 * 
	 * @param request
	 * @param exception
	 * @return
	 * @throws IOException
	 */
	@ExceptionHandler(value = ArrayIndexOutOfBoundsException.class)
	@ResponseBody
	public ResponseEntity<ErrorResponse> handleArrayIndexOutOfBoundsException(final HttpServletRequest request,
			final ArrayIndexOutOfBoundsException exception) throws IOException {
		ErrorResponse errorResponse = new ErrorResponse();
		final ErrorDTO errorDTO = new ErrorDTO(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,
				request.getRequestURI().toString(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
				ArrayIndexOutOfBoundsException.class.getName());
		exception.printStackTrace();
		errorResponse.setError(errorDTO);
		log.error("Exception Messgae:" + exception.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	/**
	 * 
	 * @param request
	 * @param exception
	 * @return
	 * @throws IOException
	 */
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ResponseEntity<ErrorResponse> handleGenericException(final HttpServletRequest request,
			final Exception exception) throws IOException {
		ErrorResponse errorResponse = new ErrorResponse();
		final ErrorDTO errorDTO = new ErrorDTO(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,
				request.getRequestURI().toString(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
				exception.getClass().toString());
		errorResponse.setError(errorDTO);
		exception.printStackTrace();
		log.error("Exception Messgae:" + exception.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);

	}

}

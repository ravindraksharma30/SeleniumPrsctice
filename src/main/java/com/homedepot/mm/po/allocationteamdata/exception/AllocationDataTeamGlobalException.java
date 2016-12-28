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

/**
 * @author axd8472 & @author spv5283
 *
 */
@ControllerAdvice
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
	public ResponseEntity<ErrorDTO> handleNullPointerException(final HttpServletRequest request,
			final NullPointerException exception) throws IOException {
		final ErrorDTO errorDTO = new ErrorDTO(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,
				request.getRequestURI().toString(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
				NullPointerException.class.getName());

		return new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);

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
	public ResponseEntity<ErrorDTO> handleArrayIndexOutOfBoundsException(final HttpServletRequest request,
			final ArrayIndexOutOfBoundsException exception) throws IOException {
		final ErrorDTO errorDTO = new ErrorDTO(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,
				request.getRequestURI().toString(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
				ArrayIndexOutOfBoundsException.class.getName());

		return new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);

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
	public ResponseEntity<ErrorDTO> handleGenericException(final HttpServletRequest request, final Exception exception)
			throws IOException {
		final ErrorDTO errorDTO = new ErrorDTO(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,
				request.getRequestURI().toString(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
				Exception.class.getName());

		return new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);

	}

}

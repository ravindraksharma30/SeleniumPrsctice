/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.homedepot.mm.po.allocationteamdata.dto.ErrorDTO;

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
	 * @param exception
	 * @return
	 * @throws IOException
	 */
	@ExceptionHandler(value = DataNotFoundException.class)
	public @ResponseBody ErrorDTO handleException(HttpServletRequest httpRequest, DataNotFoundException exception)
			throws IOException {
		log.error(exception.getMessage());
		ErrorDTO error = new ErrorDTO(exception.getMessage(), 700, httpRequest.getRequestURI());
		return error;

	}

}

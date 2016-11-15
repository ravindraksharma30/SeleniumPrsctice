/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author axd8472 & @author spv5283
 *
 */
@ControllerAdvice
public class AllocationDataTeamGlobalException {

	@ExceptionHandler(value = NullPointerException.class)
	public void handleException(HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
	}

}

/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * @author axd8472
 *
 */

@ControllerAdvice
@Slf4j
public class AllocationDataTeamException {

	@ExceptionHandler(value = BayParmNotFoundException.class)
	public void handleException(HttpServletResponse response, BayParmNotFoundException exception) throws IOException {
		log.error(exception.getMessage());
		response.sendError(HttpStatus.NOT_FOUND.value());
	}

}

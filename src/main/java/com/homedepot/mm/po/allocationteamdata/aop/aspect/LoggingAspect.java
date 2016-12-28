/**
 * 
 */
package com.homedepot.mm.po.allocationteamdata.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * LoggingAspect is used to decouple the cross-cutting concerns(the functions
 * that span multiple points of an application are called cross-cutting concerns
 * eg of aspects like logging, auditing, declarative transactions, security anf
 * cahching etc.) from the objects they affect. Defines set of API's providing
 * cross-cutting requirements
 * 
 * 
 * @see <a href=
 *      "https://www.tutorialspoint.com/spring/aop_with_spring.htm">Spring AOP
 *      Aspect reference link</a>
 *
 **
 * 
 * @author axd8472
 *
 */
@Component
@Aspect
@Slf4j
public class LoggingAspect {

	/**
	 * 
	 * @param joinPoint
	 */
	@Before("execution(* com.homedepot.mm.po.allocationteamdata..*.*(..))")
	public void logBefore(JoinPoint joinPoint) {
		log.info("Inside " + joinPoint.getSignature().getName());
	}

	/**
	 * 
	 * @param joinPoint
	 */
	@After("execution(* com.homedepot.mm.po.allocationteamdata..*.*(..))")
	public void logAfter(JoinPoint joinPoint) {
		log.info("Exiting " + joinPoint.getSignature().getName());
	}

	/**
	 * 
	 * @param exception
	 */

	@AfterThrowing(pointcut = "execution(* com.homedepot.mm.po.allocationteamdata..*.*(..))", throwing = "exception")
	public void logAfterThrowing(Exception exception) {
		log.error("Exception " + exception.getMessage());

	}
}

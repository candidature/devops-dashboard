package com.broadcom.devopsd.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class DevopsLoggingAspect {
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.broadcom.devopsd.controller.*.*(..))")
	private void forControllerPackage() {}
	
	
	//
	
	@Pointcut("execution(* com.broadcom.devopsd.service.*.*(..))")
	private void forServicePackage() {}
	
	
	@Pointcut("execution(* com.broadcom.devopsd.controller.*.*(..))")
	private void forDaoPackage() {}
	
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().toShortString();
		
		logger.info("===========>>> @Before calling: " +method);
		
		Object args[] = joinPoint.getArgs();
		
		for (Object arg: args) {
			System.out.println("==============>>>> Arguments " + arg);
		}
	}
	
	//Add afterreturn advice.
	
	@AfterReturning(
				pointcut="forAppFlow()",
				returning="result"
				)
	public void afterReturning(JoinPoint joinPoint, Object result) {
		//Display method returning and data(result)
		String method = joinPoint.getSignature().toShortString();
		logger.info("===========>>> @After Returning from : " +method);
		
		logger.info("===========>>> Result: " + result);
		
	}
}

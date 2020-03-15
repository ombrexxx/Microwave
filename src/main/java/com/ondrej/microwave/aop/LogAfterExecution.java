package com.ondrej.microwave.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAfterExecution {

	private static final Logger logger = LoggerFactory.getLogger(LogAfterExecution.class);
	
	@AfterReturning(pointcut = "execution(public String com.ondrej.microwave.service.MicrowaveServiceImpl.*(..))", returning = "message")
	public void runAfter(JoinPoint joinPoint, String message) throws Throwable {
		logger.info(message);
	}

}

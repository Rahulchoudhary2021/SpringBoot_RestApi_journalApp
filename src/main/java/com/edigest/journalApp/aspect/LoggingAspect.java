package com.edigest.journalApp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	public void logBefore(JoinPoint  JoinPoint ) {
		System.out.println(JoinPoint .getSignature().getName());
	}
	
}

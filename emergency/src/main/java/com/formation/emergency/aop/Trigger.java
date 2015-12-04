package com.formation.emergency.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class Trigger {
	//private static Writer LOGGER = Logger.getLogger(Trigger.class);
	
	@Autowired
	private Writer LOGGER= null;
			
	public Object aroundExecution(final ProceedingJoinPoint joinpoint) throws Throwable {
		Object returnValue;
		LOGGER.Log("----------------ENTER-----------------");
		System.out.println("-----------------------");
		returnValue=joinpoint.proceed();
		System.out.println("+++++++++++++++++++++++");
		LOGGER.Log("----------------LEAVE-----------------");
		return returnValue;
	}
}

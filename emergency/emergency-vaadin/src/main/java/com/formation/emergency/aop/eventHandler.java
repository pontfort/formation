package com.formation.emergency.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class eventHandler {

	private static Writer writer = new Writer();
	
	public Object around(final ProceedingJoinPoint joinpoint) throws Throwable{
		Object returnValue;
		writer.write(joinpoint.getSignature() + "start");
		returnValue = joinpoint.proceed();
		writer.write(joinpoint.getSignature() + "finish");
		return returnValue;
	}
}

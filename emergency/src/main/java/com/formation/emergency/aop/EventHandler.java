package com.formation.emergency.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

public class EventHandler  {

	@Autowired
	private Writer writer;
	
	public Object myFunction(final ProceedingJoinPoint jointpoint) throws Throwable {
		Object returnValue;
		writer.log("Start : " + jointpoint.getSignature());
		returnValue = jointpoint.proceed();
		writer.log("End : " + jointpoint.getSignature());
		return returnValue;
	}
	
	public Object logDao(final ProceedingJoinPoint jointpoint) throws Throwable {		
		Object returnValue;
		writer.log("DAO : " + jointpoint.getSignature());
		returnValue = jointpoint.proceed();		
		return returnValue;		
	}
	
	public Object logSetProperty(final ProceedingJoinPoint jointpoint) throws Throwable {		
		Object returnValue;
		writer.log("SetProperty : " + jointpoint.getSignature() + "=" + jointpoint.getArgs()[0]);
		returnValue = jointpoint.proceed();		
		return returnValue;		
	}	

	public Writer getWriter() {
		return writer;
	}

	public void setWriter(Writer writer) {
		this.writer = writer;
	}
}

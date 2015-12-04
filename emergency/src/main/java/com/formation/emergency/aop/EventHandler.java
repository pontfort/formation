package com.formation.emergency.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

public class EventHandler {

	@Autowired
	private	Writer writer;
	
	public Object aroundExecution(final ProceedingJoinPoint joinPoint) throws Throwable {
		
		Object returnValue = null;
		try{
			writer.write(joinPoint.getSignature() + "start");

			returnValue = joinPoint.proceed();
			
			writer.write(joinPoint.getSignature() + "finish");
		}
		catch(Exception ex){
			writer.write(joinPoint.getSignature() + "throwAround " + ex.getMessage());
		}
		
		return returnValue;
	}
	
	public Writer getWriter() {
		return writer;
	}

	public void setWriter(Writer writer) {
		this.writer = writer;
	}
}

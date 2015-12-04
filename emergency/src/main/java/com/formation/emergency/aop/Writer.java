package com.formation.emergency.aop;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Component
public class Writer {
	
	private static Logger LOGGER = Logger.getLogger(EventHandler.class);
	
	public void write(String message)
	{
		LOGGER.info(message);
		System.out.println(message);
	}
}

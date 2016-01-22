package com.formation.emergency.aop;

import org.springframework.stereotype.Component;

@Component
public class Writer {

	public void write(String log){
		System.out.println(log);
	}
}

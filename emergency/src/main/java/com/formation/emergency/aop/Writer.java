package com.formation.emergency.aop;

import org.springframework.stereotype.Component;

@Component
public class Writer {
	
	void log(String chaine) {
		System.out.println(chaine);
	}

}

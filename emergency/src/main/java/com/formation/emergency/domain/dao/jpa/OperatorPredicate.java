package com.formation.emergency.domain.dao.jpa;

public enum OperatorPredicate {
	
	GREATER_THAN(">"), 
	LESS_THAN("<"), 
	EQUAL("="), 
	NOTEQUAL("<>"), 
	LIKE("LIKE"),
	STEMMING("");
	

	private String value;

	private OperatorPredicate(String message) {
		this.value = message;
	}
	
	public String getValue() {
		return value;
	}

}

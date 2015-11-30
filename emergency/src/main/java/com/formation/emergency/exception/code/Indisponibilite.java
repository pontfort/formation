package com.formation.emergency.exception.code;

public enum Indisponibilite {
	
	MORT("Il est mort"),
	IRREPARABLE("Maldonne"),
	VOLE("Sale histoire"),
	RESERVE("Lock"),
	FAUSSE_COUCHE("snif");
	
	private Indisponibilite(String message){
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

	private String message;
}

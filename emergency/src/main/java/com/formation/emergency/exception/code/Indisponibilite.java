package com.formation.emergency.exception.code;

public enum Indisponibilite {

	MORT("Il est mort"), IRREPARABLE("Maldonne"), VOLE("Sale histoire"), RESERVE("locked"), FAUSSE_COUCHE("sniff");

	private String message;

	private Indisponibilite(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}

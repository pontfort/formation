package com.formation.emergency.exception.code;

public enum Recherche {

	NULL("Le patient est null"), EXISTE("Le patient existe");

	private String message;

	private Recherche(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}

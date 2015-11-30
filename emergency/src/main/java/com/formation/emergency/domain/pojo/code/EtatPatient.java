package com.formation.emergency.domain.pojo.code;

public enum EtatPatient {

	MORT("Il est décédé"), CONSULTATION("Nouvelle consultation"), ORDONNANCE("Ordonnance"), NAISSANCE("Naissance");

	private String message;

	private EtatPatient(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}

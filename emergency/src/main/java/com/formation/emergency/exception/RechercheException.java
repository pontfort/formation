package com.formation.emergency.exception;

import com.formation.emergency.exception.code.Recherche;

public class RechercheException extends Exception {

	private static final long serialVersionUID = 1L;

	private Recherche code;

	public RechercheException() {
		super();
	}

	public RechercheException(Recherche code, String message) {
		super(code.getMessage() + " " + message);
		this.code = code;
	}

	public Recherche getCode() {
		return code;
	}

	public void setCode(Recherche code) {
		this.code = code;
	}

}

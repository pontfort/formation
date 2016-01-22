package com.formation.emergency.exception;

import java.io.Serializable;

import com.formation.emergency.exception.code.Indisponibilite;

public class IndisponibiliteException extends Exception implements Serializable{

	private static final long serialVersionUID = 1L;

	private Indisponibilite code;

	public IndisponibiliteException() {
		super();
	}

	public IndisponibiliteException(Indisponibilite code, String message) {
		super(code.getMessage() + " " + message);
		this.code = code;
	}

	public Indisponibilite getCode() {
		return code;
	}

	public void setCode(Indisponibilite code) {
		this.code = code;
	}

}

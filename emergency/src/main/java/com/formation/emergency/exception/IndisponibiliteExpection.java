package com.formation.emergency.exception;

import com.formation.emergency.exception.code.Indisponibilite;

public class IndisponibiliteExpection extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IndisponibiliteExpection() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IndisponibiliteExpection(Indisponibilite code, String message) {
		super(message);
		this.code = code;
		// TODO Auto-generated constructor stub
	}

	private Indisponibilite code;

	public Indisponibilite getCode() {
		return code;
	}

	public void setCode(Indisponibilite code) {
		this.code = code;
	}
	
}

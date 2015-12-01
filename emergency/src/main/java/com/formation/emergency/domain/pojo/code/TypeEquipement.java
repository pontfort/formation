package com.formation.emergency.domain.pojo.code;

public enum TypeEquipement {

	VOITURE("Ambulance"), BUREAU("Bureau"), APPAREIL_RADIO("Appareil radio");

	private String message;

	private TypeEquipement(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}

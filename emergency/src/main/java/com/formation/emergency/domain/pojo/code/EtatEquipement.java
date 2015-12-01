package com.formation.emergency.domain.pojo.code;

public enum EtatEquipement {

	CASSE("Le matériel est cassé"), FONCTIONNEL("En état de fonctionnement");

	private String message;

	private EtatEquipement(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}

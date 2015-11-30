package com.formation.emergency.domain.pojo;

public class Patient extends Personne {	
	
	//TODO non obligatoire
	private Adresse adresse;
	
	private String numeroSECU;

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
}

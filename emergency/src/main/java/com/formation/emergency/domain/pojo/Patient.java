package com.formation.emergency.domain.pojo;

public class Patient extends Personne {

	// TODO non obligatoire
	private Adresse adresse;

	private String numeroSecu;

	public String getNumeroSecu() {
		return numeroSecu;
	}

	public void setNumeroSecu(String numeroSecu) {
		this.numeroSecu = numeroSecu;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

}

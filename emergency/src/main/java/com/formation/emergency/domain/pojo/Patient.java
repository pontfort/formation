package com.formation.emergency.domain.pojo;

import java.sql.Date;

public class Patient extends Personne {
	
	//TODO non obligatoire
	private Adresse adresse;
	private String numeroSecu;
	private EtatPatient etatPatient;
	
	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public String getNumeroSecu() {
		return numeroSecu;
	}

	public void setNumeroSecu(String numeroSecu) {
		this.numeroSecu = numeroSecu;
	}

	public EtatPatient getEtatPatient() {
		return etatPatient;
	}

	public void setEtatPatient(EtatPatient etatPatient) {
		this.etatPatient = etatPatient;
	}
	
}

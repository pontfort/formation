package com.formation.emergency.domain.pojo;

import com.formation.emergency.domain.pojo.code.EtatPatient;

public class Patient extends Personne {	
	
	//TODO non obligatoire
	private Adresse adresse;
	
	private String numeroSECU;
	
	private EtatPatient etat;

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	public String getNumeroSECU() {
		return numeroSECU;
	}

	public void setNumeroSECU(String numeroSECU) {
		this.numeroSECU = numeroSECU;
	}
	
	public EtatPatient getEtat() {
		return etat;
	}

	public void setEtat(EtatPatient etat) {
		this.etat = etat;
	}


	@Override
	public String toString() {
		return super.toString() + " - numeroSECU = " + numeroSECU + "(Patient)";
	}	
	
	
}

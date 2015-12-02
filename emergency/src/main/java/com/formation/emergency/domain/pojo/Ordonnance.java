package com.formation.emergency.domain.pojo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Ordonnance extends FeuilleSortie{

	private String prescription; 
		
	@EmbeddedId
	private Adresse adresse;

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
}

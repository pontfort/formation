package com.formation.emergency.domain.pojo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Ordonnance extends FeuilleSortie {

	@EmbeddedId
	private Adresse adresse;

	private String prescriptions;

	public Ordonnance() {
		super();
	}

	public Ordonnance(String prescriptions) {
		super();
		this.prescriptions = prescriptions;
	}

	public String getPrescriptions() {
		return prescriptions;
	}

	public void setPrescriptions(String prescriptions) {
		this.prescriptions = prescriptions;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Ordonnance";
	}

}

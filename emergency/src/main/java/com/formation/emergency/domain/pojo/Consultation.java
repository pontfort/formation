package com.formation.emergency.domain.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Consultation extends FeuilleSortie {

	@Column(name = "md")
	private String medecin;

	public String getMedecin() {
		return medecin;
	}

	public void setMedecin(String medecin) {
		this.medecin = medecin;
	}
}

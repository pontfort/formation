package com.formation.emergency.domain.pojo.feuilles;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "CONSULTATION")
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

package com.formation.emergency.domain.pojo.feuilles;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "ORDONNANCE")
public class Ordonnance extends FeuilleSortie {

	@Column(name = "presc")
	private String prescription;

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

}

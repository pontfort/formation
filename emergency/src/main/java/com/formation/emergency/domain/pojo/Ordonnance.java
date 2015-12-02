package com.formation.emergency.domain.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
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

package com.formation.emergency.domain.pojo.feuilles;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ordonnance extends FeuilleSortie {
	
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
	
	@Override
	public String toString() {
		return "Ordonnance";
	}

}

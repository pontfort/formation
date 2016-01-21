package com.formation.emergency.domain.pojo.feuilles;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="ORDONNANCE")
public class Ordonnance extends FeuilleSortie implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

package com.formation.emergency.domain.pojo;

import javax.persistence.*;

@Entity
@DiscriminatorValue("ORDONNANCE")
public class Ordonnance extends FeuilleSortie {

	private String prescription;

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}

package com.formation.emergency.domain.pojo;

import javax.persistence.Entity;

@Entity
public class Ambulance extends Equipement {

	private double kilometrage;

	public Ambulance() {
	}

	public Ambulance(String reference, String nom) {
		super(reference,nom);
	}

	public double getKilometrage() {
		return kilometrage;
	}

	public void setKilometrage(double kilometrage) {
		this.kilometrage = kilometrage;
	}
}

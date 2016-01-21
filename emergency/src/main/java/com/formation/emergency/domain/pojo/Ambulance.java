package com.formation.emergency.domain.pojo;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Ambulance extends Equipement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double kilometrage;

	public Ambulance() {
	}

	public Ambulance(String reference, String nom) {
		super(reference, nom);
	}

	public double getKilometrage() {
		return kilometrage;
	}

	public void setKilometrage(double kilometrage) {
		this.kilometrage = kilometrage;
	}
}

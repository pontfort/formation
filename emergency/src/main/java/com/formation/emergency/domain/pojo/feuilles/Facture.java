package com.formation.emergency.domain.pojo.feuilles;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="FACTURE")
public class Facture extends FeuilleSortie implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double prix;

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	

}

package com.formation.emergency.domain.pojo.feuilles;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="FACTURE")
public class Facture extends FeuilleSortie {
	
	private double prix;

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	

}

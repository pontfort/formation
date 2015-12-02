package com.formation.emergency.domain.pojo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Adresse implements Serializable {

	@Column(name = "label1")
	private String libelle1;
	@Column(name = "label2")
	private String libelle2;
	@Column(name = "town")
	private String ville;
	@Column(name = "zipcode")
	private int codePostal;

	public String getLibelle1() {
		return libelle1;
	}

	public void setLibelle1(String libelle1) {
		this.libelle1 = libelle1;
	}

	public String getLibelle2() {
		return libelle2;
	}

	public void setLibelle2(String libelle2) {
		this.libelle2 = libelle2;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Adresse adresse = (Adresse) obj;
		return ((libelle1 == adresse.getLibelle1()) && (libelle2 == adresse.getLibelle2())
				&& (ville == adresse.getVille()) && (codePostal == adresse.getCodePostal()));
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return libelle1.hashCode() + libelle2.hashCode() + ville.hashCode() + codePostal;
	}

}

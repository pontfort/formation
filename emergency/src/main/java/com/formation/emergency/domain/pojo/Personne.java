package com.formation.emergency.domain.pojo;

import java.util.Date;

public class Personne {
	
	//TODO obligatoire
	private Date dateNaissance;
	
	private String nom;
	
	private String prenom;
	
	private Personne mere;
	
	private Personne pere;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public Personne getMere() {
		return mere;
	}
	public void setMere(Personne mere) {
		this.mere = mere;
	}
	public Personne getPere() {
		return pere;
	}
	public void setPere(Personne pere) {
		this.pere = pere;
	}
	
}

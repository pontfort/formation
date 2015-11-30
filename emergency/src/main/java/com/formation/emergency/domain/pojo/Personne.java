package com.formation.emergency.domain.pojo;

import java.sql.Date;

public class Personne {

	private String nom;
	private String prenom;
	
	private Date dateNaissance;
	private Personne pere;
	private Personne mere;
	
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
	public Personne getPere() {
		return pere;
	}
	public void setPere(Personne pere) {
		this.pere = pere;
	}
	public Personne getMere() {
		return mere;
	}
	public void setMere(Personne mere) {
		this.mere = mere;
	}
}

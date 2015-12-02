package com.formation.emergency.domain.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@MappedSuperclass
public class Personne {
		
	@Column(name="Nom_Personne")
	private String nom;
	
	@Column(name="Prenom_Personne")
	private String prenom;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DateNaissance_Personne")
	private Date dateNaissance;
	
	@Transient
	private Personne mere;
	
	@Transient
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

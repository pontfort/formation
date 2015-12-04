package com.formation.emergency.domain.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="discriminator_personne", discriminatorType=DiscriminatorType.STRING)
public class Personne {
		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id_Patient")
	private int id;
	
	@Column(name="Nom_Personne")
	private String nom;
	
	@Column(name="Prenom_Personne")
	private String prenom;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DateNaissance_Personne")
	private Date dateNaissance;
	
	@ManyToOne
	private Personne mere;
	
	@ManyToOne
	private Personne pere;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="mere_enfant")
	private List<Personne> enfants = new ArrayList<Personne>();
	
	public List<Personne> getEnfants() {
		return enfants;
	}

	public void setEnfants(List<Personne> enfants) {
		this.enfants = enfants;
	}

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
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}

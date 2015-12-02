package com.formation.emergency.domain.pojo.feuilles;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TypeFeuille", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue(value="FEUILLE")
public abstract class FeuilleSortie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_FeuilleSortie")
	private int id;

//  Si present (Cas 1)		-> La FK vers la personne est dans feuille de sortie
//  Si non présent (Cas 2)	-> La reference est porté par une table personne_feuillesortie qui contient les primary keys de Personne et FeuilleSortie 
//	@ManyToOne
//	@JoinColumn
//	private Personne personne;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
		
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateSortie;

	public Date getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(Date date) {
		this.dateSortie = date;
	}

//	public Personne getPersonne() {
//		return personne;
//	}
//
//	public void setPersonne(Personne personne) {
//		this.personne = personne;
//	}	

}

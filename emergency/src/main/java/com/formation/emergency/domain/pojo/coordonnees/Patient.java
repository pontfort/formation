package com.formation.emergency.domain.pojo.coordonnees;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import com.formation.emergency.domain.pojo.code.EtatPatient;

@Entity
@DiscriminatorValue(value = "PATIENT")
@NamedQueries({ @NamedQuery(name = "patient.update", query = "update Patient p set p.etat = :etat, p.numeroSecu = :numeroSecu, p.nom = :nom, p.prenom = :prenom, p.dateNaissance = :dateNaissance where p.id = :id"),
		@NamedQuery(name = "patient.delete", query = "delete Patient p where p.id = :id") })
public class Patient extends Personne implements Serializable {

	private static final long serialVersionUID = 1L;

	@Embedded
	private Adresse adresse;

	@Column(name = "numero_secu")
	private String numeroSecu;

	@Enumerated(EnumType.STRING)
	private EtatPatient etat;

	public EtatPatient getEtat() {
		return etat;
	}

	public void setEtat(EtatPatient etat) {
		this.etat = etat;
	}

	public String getNumeroSecu() {
		return numeroSecu;
	}

	public void setNumeroSecu(String numeroSecu) {
		this.numeroSecu = numeroSecu;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return String.format("Patient [adresse=%s, numeroSecu=%s, toString()=%s]", adresse, numeroSecu,
				super.toString());
	}

	public String getUID() {
		return getNom() + getPrenom() + getNumeroSecu();
	}

}

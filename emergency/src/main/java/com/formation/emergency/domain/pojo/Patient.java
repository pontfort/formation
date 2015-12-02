package com.formation.emergency.domain.pojo;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
@Entity
public class Patient extends Personne {

	// TODO non obligatoire
	@Embedded
	private Adresse adresse;
	@Column(name = "security_number")
	private String numeroSecu;
	@Enumerated(EnumType.STRING)
	@Column(name = "state")
	private EtatPatient etat;

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

	public EtatPatient getEtat() {
		return etat;
	}

	public void setEtat(EtatPatient etat) {
		this.etat = etat;
	}

}

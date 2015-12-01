package com.formation.emergency.domain.pojo;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.formation.emergency.domain.pojo.code.EtatPatient;

@Entity
public class Patient extends Personne {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Embedded
	private Adresse adresse;

	private String numeroSecu;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

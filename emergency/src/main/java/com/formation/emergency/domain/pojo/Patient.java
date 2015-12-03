package com.formation.emergency.domain.pojo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import com.formation.emergency.domain.dao.QueriesDictionary;
import com.formation.emergency.domain.pojo.code.EtatPatient;

@Entity
@DiscriminatorValue(value = "PATIENT")
@NamedQueries({
		@NamedQuery(name = QueriesDictionary.PATIENT_UPDATE_NUMSECU, query = "UPDATE Patient p SET p.numeroSecu=:"
				+ QueriesDictionary.PATIENT_QUERYPARAM_NUMSECU + " WHERE p.id=:" + QueriesDictionary.PATIENT_QUERYPARAM_ID),
		@NamedQuery(name = QueriesDictionary.PATIENT_DELETE, query = "DELETE Patient p WHERE p.id=:"
				+ QueriesDictionary.PATIENT_QUERYPARAM_ID) })
public class Patient extends Personne {

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

	@Override
	public String toString() {
		return String.format("Patient [adresse=%s, numeroSecu=%s, toString()=%s]", adresse, numeroSecu,
				super.toString());
	}

	public String getUID() {
		return getNom() + getPrenom() + getNumeroSecu();
	}

}

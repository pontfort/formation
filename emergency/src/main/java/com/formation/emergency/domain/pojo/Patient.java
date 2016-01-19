package com.formation.emergency.domain.pojo;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import com.formation.emergency.domain.dao.repository.QueriesDictonary;

@Entity
@DiscriminatorValue(value = "PATIENT")
@NamedQueries({
	@NamedQuery(name = QueriesDictonary.PATIENT_UPDATE_ETAT, query = "UPDATE Patient p SET p.etat = :"+ QueriesDictonary.PATIENT_ETAT + " WHERE p.id = :" + QueriesDictonary.PATIENT_ID),
	@NamedQuery(name = QueriesDictonary.PATIENT_DELETE, query = "DELETE Patient p WHERE p.id = :" + QueriesDictonary.PATIENT_ID)
})
public class Patient extends Personne {
	
	// TODO non obligatoire
	@Embedded
	private Adresse adresse;
	@Column(name = "security_number")
	private String numeroSecu;
	@Enumerated(EnumType.STRING)
	@Column(name = "state")
	private EtatPatient etat;

	public Patient(String nom, String prenom) {
		super(nom, prenom);
	}

	public Patient() {
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

	public EtatPatient getEtat() {
		return etat;
	}

	public void setEtat(EtatPatient etat) {
		this.etat = etat;
	}

}

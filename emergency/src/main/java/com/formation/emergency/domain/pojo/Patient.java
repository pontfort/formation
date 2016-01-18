package com.formation.emergency.domain.pojo;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.formation.emergency.domain.dao.repository.QueriesDictionary;
import com.formation.emergency.domain.pojo.code.EtatPatient;

@Entity
@DiscriminatorValue(value="PATIENT")
@NamedQueries({
	@NamedQuery(name=QueriesDictionary.PATIENT_UPDATE,query="UPDATE Patient p SET p.etat = :" + QueriesDictionary.PATIENT_QUERY_PARAM_ETAT + ",p.numeroSECU = :" + QueriesDictionary.PATIENT_QUERY_PARAM_SECU + ", p.nom = :" + QueriesDictionary.PATIENT_QUERY_PARAM_NOM + ", p.prenom = :" + QueriesDictionary.PATIENT_QUERY_PARAM_PRENOM + " WHERE p.id = :" + QueriesDictionary.PATIENT_QUERY_PARAM_ID),
	@NamedQuery(name=QueriesDictionary.PATIENT_UPDATE_ETAT,query="UPDATE Patient p SET etat = :" + QueriesDictionary.PATIENT_QUERY_PARAM_ETAT + " WHERE p.id = :" + QueriesDictionary.PATIENT_QUERY_PARAM_ID),
	@NamedQuery(name=QueriesDictionary.PATIENT_DELETE,query="DELETE Patient p WHERE p.id = :" + QueriesDictionary.PATIENT_QUERY_PARAM_ID)
})
public class Patient extends Personne {
	
	@Embedded
	private Adresse adresse;

	@NotNull
	@Size(min = 15, max = 15)
	@Column(name = "secu", length = 50)
	private String numeroSECU;

	@Enumerated(EnumType.STRING)
	private EtatPatient etat = EtatPatient.AUCUN;

	public Patient() {
	}
	
	public Patient(String nom, String prenom) {
		super(nom,prenom);
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public String getNumeroSECU() {
		return numeroSECU;
	}

	public void setNumeroSECU(String numeroSECU) {
		this.numeroSECU = numeroSECU;
	}

	public EtatPatient getEtat() {
		return etat;
	}

	public void setEtat(EtatPatient etat) {
		this.etat = etat;
	}	

	@Override
	public String toString() {
		return super.toString() + " - numeroSECU = " + numeroSECU + "(Patient)";
	}

}

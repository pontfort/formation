package com.formation.emergency.domain.pojo;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.formation.emergency.domain.pojo.code.EtatPatient;

@Entity
public class Patient extends Personne {		
		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Embedded
	private Adresse adresse;
		
	@NotNull @Size(min=15,max=15)
	@Column(length=50)
	private String numeroSECU;
	
	@Enumerated(EnumType.STRING)
	private EtatPatient etat;
	
	public Patient() {
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

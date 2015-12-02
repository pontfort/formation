package com.formation.emergency.domain.pojo.feuilles;

import java.util.Date;

import javax.persistence.Entity;

import com.formation.emergency.domain.pojo.Patient;

@Entity
public class ActeNaissance extends Acte {

	private transient Patient patient;
	
	private Date dateNaissance;

	@Override
	public String toString() {
		return "ActeNaissance";
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
}

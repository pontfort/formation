package com.formation.emergency.domain.pojo.feuilles;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.formation.emergency.domain.pojo.Patient;

@Entity
@DiscriminatorValue(value="ACTENAISSANCE")
public class ActeNaissance extends Acte implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

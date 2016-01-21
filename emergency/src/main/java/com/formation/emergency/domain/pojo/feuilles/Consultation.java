package com.formation.emergency.domain.pojo.feuilles;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="CONSULTATION")
public class Consultation extends FeuilleSortie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="lieu_du_rendez_vous")
	private String lieu_rdv;

	@Override
	public String toString() {
		return "Consultation";
	}

	public String getLieu_rdv() {
		return lieu_rdv;
	}

	public void setLieu_rdv(String lieu_rdv) {
		this.lieu_rdv = lieu_rdv;
	}

}

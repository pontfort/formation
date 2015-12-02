package com.formation.emergency.domain.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ActeNaissance extends FeuilleSortie {

	@Column(name = "birth_date")
	private Date date_naissance;

	public Date getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}
}

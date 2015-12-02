package com.formation.emergency.domain.pojo.feuilles;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Acte extends FeuilleSortie {

	@Column(name = "date_acte")
	private Date dateActe;

	public Date getDateActe() {
		return dateActe;
	}

	public void setDateActe(Date dateActe) {
		this.dateActe = dateActe;
	}

}

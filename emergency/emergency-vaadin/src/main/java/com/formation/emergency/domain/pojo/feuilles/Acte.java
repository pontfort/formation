package com.formation.emergency.domain.pojo.feuilles;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "ACTE")
public abstract class Acte extends FeuilleSortie {

	@Column(name = "acte_date")
	private Date date_acte;

	public Date getDate_mort() {
		return date_acte;
	}

	public void setDate_mort(Date date_acte) {
		this.date_acte = date_acte;
	}
}

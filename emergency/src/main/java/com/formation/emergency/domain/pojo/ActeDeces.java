package com.formation.emergency.domain.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ActeDeces extends FeuilleSortie {

	@Column(name = "death_date")
	private Date date_mort;

	public Date getDate_mort() {
		return date_mort;
	}

	public void setDate_mort(Date date_mort) {
		this.date_mort = date_mort;
	}
}

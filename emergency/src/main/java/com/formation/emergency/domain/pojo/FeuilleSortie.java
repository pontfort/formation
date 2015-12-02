package com.formation.emergency.domain.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class FeuilleSortie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "exit_sheet_id")
	int id;
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "exit_date")
	private Date date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}

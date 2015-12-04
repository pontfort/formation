package com.formation.emergency.domain.pojo.feuilles;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.formation.emergency.domain.pojo.Personne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminator_feuille")
@DiscriminatorValue(value = "FEUILLESORTIE")
public abstract class FeuilleSortie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "exit_sheet_id")
	int id;
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "exit_date")
	private Date date;
	@JoinColumn(name = "people_exitsheet")
	@ManyToOne
	private Personne personne;

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

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

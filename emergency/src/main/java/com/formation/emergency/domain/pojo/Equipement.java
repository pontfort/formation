package com.formation.emergency.domain.pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.formation.emergency.domain.dao.QueriesDictonary;

@Entity
@DiscriminatorValue(value = "EQUIPEMENT")
@NamedQueries({
	@NamedQuery(name = QueriesDictonary.EQUIPEMENT_UPDATE_DISPONIBLE, query = "UPDATE Equipement e SET e.disponible = :"+ QueriesDictonary.EQUIPEMENT_DISPONIBLE + " WHERE e.id = :" + QueriesDictonary.EQUIPEMENT_ID),
	@NamedQuery(name = QueriesDictonary.EQUIPEMENT_DELETE, query = "DELETE Equipement e WHERE e.id = :" + QueriesDictonary.EQUIPEMENT_ID)
})
public class Equipement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "machine_id")
	private Long id;
	@Column(name = "ref")
	private String reference;
	@Column(name = "available")
	private boolean disponible;
	private Date dateAchat;
	private String paysOrigine;

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateAchat() {
		return dateAchat;
	}

	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}

	public String getPaysOrigine() {
		return paysOrigine;
	}

	public void setPaysOrigine(String paysOrigine) {
		this.paysOrigine = paysOrigine;
	}
}

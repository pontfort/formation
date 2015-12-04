package com.formation.emergency.domain.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Equipement")
public class Equipement {
	
	@Id
	@Column(name="Reference_Equipement")
	private String reference;
	
	@Enumerated(EnumType.STRING)
	@Column(name="Type_Equipement")
	private TypeEquipement typeEquipement;
	
	@Enumerated(EnumType.STRING)
	@Column(name="Etat_Equipement")
	private EtatEquipement etatEquipement;
	
	@Column(name="DateAchat_Equipement")
	private Date dateAchat;
	
	@Column(name="PaysOrigine_Equipement")
	private String paysOrigine;
	
	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public TypeEquipement getTypeEquipement() {
		return typeEquipement;
	}

	public void setTypeEquipement(TypeEquipement typeEquipement) {
		this.typeEquipement = typeEquipement;
	}

	public EtatEquipement getEtatEquipement() {
		return etatEquipement;
	}

	public void setEtatEquipement(EtatEquipement etatEquipement) {
		this.etatEquipement = etatEquipement;
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

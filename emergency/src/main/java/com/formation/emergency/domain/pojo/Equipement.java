package com.formation.emergency.domain.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.formation.emergency.domain.dao.QueriesDictionary;
import com.formation.emergency.domain.pojo.code.EtatEquipement;
import com.formation.emergency.domain.pojo.code.TypeEquipement;

@Entity
@Table(name = "machine")
@NamedQueries({ @NamedQuery(name = QueriesDictionary.EQUIPEMENT_DELETE, query = "DELETE Equipement e WHERE e.id=:"
		+ QueriesDictionary.EQUIPEMENT_QUERYPARAM_ID) })
public class Equipement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	@Enumerated(EnumType.STRING)
	TypeEquipement type;

	@Enumerated(EnumType.STRING)
	EtatEquipement etat;

	Date dateAchat;
	String paysOrigine;
	String reference;
	Integer prix;

	public Integer getPrix() {
		return prix;
	}

	public void setPrix(Integer prix) {
		this.prix = prix;
	}

	/**
	 * @return the dateAchat
	 */
	public Date getDateAchat() {
		return dateAchat;
	}

	/**
	 * @param dateAchat
	 *            the dateAchat to set
	 */
	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}

	/**
	 * @return the paysOrigine
	 */
	public String getPaysOrigine() {
		return paysOrigine;
	}

	/**
	 * @param paysOrigine
	 *            the paysOrigine to set
	 */
	public void setPaysOrigine(String paysOrigine) {
		this.paysOrigine = paysOrigine;
	}

	/**
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * @param reference
	 *            the reference to set
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}

	public TypeEquipement getType() {
		return type;
	}

	public void setType(TypeEquipement type) {
		this.type = type;
	}

	public EtatEquipement getEtat() {
		return etat;
	}

	public void setEtat(EtatEquipement etat) {
		this.etat = etat;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}

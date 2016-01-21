package com.formation.emergency.domain.pojo;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

import com.formation.emergency.domain.dao.repository.QueriesDictionary;

@Entity
@Table(name = "machine")
@NamedQueries({
		@NamedQuery(name = QueriesDictionary.EQUIPEMENT_UPDATE, query = "UPDATE Equipement e SET e.reference = :"
				+ QueriesDictionary.EQUIPEMENT_QUERY_PARAM_REFERENCE + ",e.etat = :"
				+ QueriesDictionary.EQUIPEMENT_QUERY_PARAM_ETAT + ", e.nom = :"
				+ QueriesDictionary.PATIENT_QUERY_PARAM_NOM + ", e.reserve = :"
				+ QueriesDictionary.EQUIPEMENT_QUERY_PARAM_RESERVE + " WHERE e.id = :"
				+ QueriesDictionary.EQUIPEMENT_QUERY_PARAM_ID),
		@NamedQuery(name = QueriesDictionary.EQUIPEMENT_DELETE, query = "DELETE Equipement e WHERE e.id = :"
				+ QueriesDictionary.EQUIPEMENT_QUERY_PARAM_ID) })
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Equipement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String reference;

	@NotNull
	@Size(min = 1)
	private String nom;

	@Enumerated(EnumType.STRING)
	private EtatEquipement etat = EtatEquipement.FONCTIONNE;

	private boolean reserve = false;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date dateAchat;

	private String PaysOrigine;

	private int price;

	public Equipement() {
	}

	public Equipement(String reference, String nom) {
		this();
		this.reference = reference;
		this.nom = nom;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReference() {
		return this.reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public boolean isReserve() {
		return reserve;
	}

	public void setReserve(boolean reserve) {
		this.reserve = reserve;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public EtatEquipement getEtat() {
		return etat;
	}

	public void setEtat(EtatEquipement etat) {
		this.etat = etat;
	}

	@Override
	public String toString() {
		return "Equipement [" + (reference != null ? "reference=" + reference + ", " : "")
				+ (nom != null ? "nom=" + nom : "") + "]";
	}

	public Date getDateAchat() {
		return dateAchat;
	}

	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}

	public String getPaysOrigine() {
		return PaysOrigine;
	}

	public void setPaysOrigine(String paysOrigine) {
		PaysOrigine = paysOrigine;
	}
}

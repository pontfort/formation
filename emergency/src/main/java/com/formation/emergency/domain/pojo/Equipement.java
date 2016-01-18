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

import com.formation.emergency.domain.dao.repository.QueriesDictionary;

@Entity
@Table(name="machine")
@NamedQueries({
	@NamedQuery(name=QueriesDictionary.EQUIPEMENT_UPDATE,query="UPDATE Equipement e SET e.reference = :" + QueriesDictionary.EQUIPEMENT_QUERY_PARAM_REFERENCE + ",e.etat = :" + QueriesDictionary.EQUIPEMENT_QUERY_PARAM_ETAT + ", e.nom = :" + QueriesDictionary.PATIENT_QUERY_PARAM_NOM + ", e.reserve = :" + QueriesDictionary.EQUIPEMENT_QUERY_PARAM_RESERVE + " WHERE e.id = :" + QueriesDictionary.EQUIPEMENT_QUERY_PARAM_ID),
	@NamedQuery(name=QueriesDictionary.EQUIPEMENT_DELETE,query="DELETE Equipement e WHERE e.id = :" + QueriesDictionary.EQUIPEMENT_QUERY_PARAM_ID)	
})
public class Equipement {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String reference;
	
	private String nom;
	
	@Enumerated(EnumType.STRING)
	private EtatEquipement etat = EtatEquipement.FONCTIONNE;
	
	private boolean reserve = false;
	
	private Date dateAchat;
	
	private String PaysOrigine;
	
	private float prix;
	
	public Equipement() {
	}
	
	public Equipement(String reference, String nom) {
		this();
		this.reference = reference;
		this.nom = nom;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}	
}

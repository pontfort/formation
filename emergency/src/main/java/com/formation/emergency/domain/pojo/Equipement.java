package com.formation.emergency.domain.pojo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="machine")
public class Equipement {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String reference;
	
	private String nom;
	
	@Enumerated(EnumType.STRING)
	private EtatEquipement etat = EtatEquipement.FONCTIONNE;
	
	private boolean reserve = false;
	
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
}

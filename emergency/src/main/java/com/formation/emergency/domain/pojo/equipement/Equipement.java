package com.formation.emergency.domain.pojo.equipement;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.formation.emergency.domain.pojo.code.EtatEquipement;
import com.formation.emergency.domain.pojo.code.TypeEquipement;

@Entity
@Table(name = "equipement")
@DiscriminatorColumn(name = "discriminator_personne", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "EQUIPEMENT")
@NamedQueries({
		@NamedQuery(name = "equipement.update", query = "update Equipement p set p.etat = :etat, p.type = :type where p.id = :id"),
		@NamedQuery(name = "equipement.delete", query = "delete Equipement p where p.id = :id") })
public class Equipement {

	@Id
	@Column(name = "id_equipement")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private TypeEquipement type;

	@Enumerated(EnumType.STRING)
	@Column(name = "etat")
	private EtatEquipement etat;

	private String ref;

	private String name;

	private Date dateAchat;

	private String pays;

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

	public Date getDateAchet() {
		return dateAchat;
	}

	public void setDateAchet(Date dateAchet) {
		this.dateAchat = dateAchet;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("Equipement [id=%s, type=%s, etat=%s, name=%s, dateAchet=%s, pays=%s]", id, type, etat,
				name, dateAchat, pays);
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

}

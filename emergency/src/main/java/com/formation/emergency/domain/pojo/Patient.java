package com.formation.emergency.domain.pojo;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(indexes={
		@Index(name="Index_NumeroSecu_Patient",unique=true, columnList="NumeroSecu_Patient")
})
@AttributeOverrides({    
    @AttributeOverride(name = "nom", column = @Column(name = "Nom_Patient")),
    @AttributeOverride(name = "prenom", column = @Column(name = "Prenom_Patient")),
    @AttributeOverride(name = "dateNaissance", column = @Column(name = "DateNaissance_Patient"))
})
@DiscriminatorValue("PATIENT")
@NamedQueries({
	@NamedQuery(name="updateEtat", query="Update Patient p SET p.etat = :pEtat where p.id = :pId")
})
public class Patient extends Personne {

	@Embedded
	@AttributeOverrides({
	    @AttributeOverride(name = "numero", column = @Column(name = "Numero_Patient")),                       
	    @AttributeOverride(name = "rue", column = @Column(name = "Rue_Patient")),
	    @AttributeOverride(name = "codePostal", column = @Column(name = "CodePostal_Patient")),
	    @AttributeOverride(name = "ville", column = @Column(name = "Ville_Patient"))
	})
	private Adresse adresse;
	
	@Enumerated(EnumType.STRING)
	@Column(name="Etat_Patient")
	private EtatPatient etatPatient;
	
	@Column(name="NumeroSecu_Patient", length=50, nullable=false)
	private String numeroSecu;

	public String getNumeroSecu() {
		return numeroSecu;
	}

	public void setNumeroSecu(String numeroSecu) {
		this.numeroSecu = numeroSecu;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public EtatPatient getEtatPatient() {
		return etatPatient;
	}

	public void setEtatPatient(EtatPatient etatPatient) {
		this.etatPatient = etatPatient;
	}

}

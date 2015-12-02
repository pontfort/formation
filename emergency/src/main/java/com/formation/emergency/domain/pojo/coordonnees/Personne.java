package com.formation.emergency.domain.pojo.coordonnees;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.formation.emergency.domain.pojo.feuilles.FeuilleSortie;

@Entity
public class Personne {

	@Id
	@Column(name = "id_personne")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;

	@Column(name = "nom")
	private String nom;

	@Column(name = "prenom")
	private String prenom;

	@Column(name = "date_naissance_personne")
	private Date dateNaissance;

	@JoinColumn(name = "mere_child")
	@ManyToOne(cascade = CascadeType.ALL)
	private Personne mere;

	@JoinColumn(name = "pere")
	@ManyToOne(cascade = CascadeType.ALL)
	private Personne pere;

	@OneToMany(mappedBy = "mere", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private List<Personne> children;

	@OneToMany(mappedBy = "personne", cascade = CascadeType.ALL)
	private List<FeuilleSortie> feuilleSorties;

	public List<FeuilleSortie> getFeuilleSorties() {
		return feuilleSorties;
	}

	public void setFeuilleSorties(List<FeuilleSortie> feuilleSorties) {
		this.feuilleSorties = feuilleSorties;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Personne getMere() {
		return mere;
	}

	public void setMere(Personne mere) {
		this.mere = mere;
	}

	public Personne getPere() {
		return pere;
	}

	public void setPere(Personne pere) {
		this.pere = pere;
	}

	@Override
	public String toString() {
		return String.format("Personne [nom=%s, prenom=%s, dateNaissance=%s, mere=%s, pere=%s]", nom, prenom,
				dateNaissance, mere, pere);
	}

	public List<Personne> getChildren() {
		return children;
	}

	public void setChildren(List<Personne> children) {
		this.children = children;
	}

}

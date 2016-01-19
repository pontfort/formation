package com.formation.emergency.domain.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import javax.persistence.InheritanceType;
import com.formation.emergency.domain.pojo.feuilles.FeuilleSortie;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminator_personne")
@DiscriminatorValue(value = "PERSONNE")
@NamedEntityGraphs({ @NamedEntityGraph(name = "withMother", attributeNodes = { @NamedAttributeNode("mere") }),
		@NamedEntityGraph(name = "withChildren", attributeNodes = {
				@NamedAttributeNode(value = "enfants", subgraph = "childrenFeuilleSortieGraph") }, subgraphs = {
						@NamedSubgraph(name = "childrenFeuilleSortieGraph", attributeNodes = {
								@NamedAttributeNode("feuillesSortie") }) }) })
public class Personne {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column(name = "name")
	private String nom;
	@Column(name = "firstname")
	private String prenom;
	// TODO obligatoire
	@Column(name = "birth_date")
	private Date dateNaissance;
	@JoinColumn(name = "mother")
	@ManyToOne(cascade = CascadeType.ALL)
	private Personne mere;
	@JoinColumn(name = "father")
	@ManyToOne
	private Personne pere;
	@OneToMany(mappedBy = "mere", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private List<Personne> enfants;
	@OneToMany(mappedBy = "personne", cascade = CascadeType.ALL)
	private List<FeuilleSortie> feuillesSortie;

	public Personne(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}

	public Personne() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public List<Personne> getEnfants() {
		if (enfants == null) {
			enfants = new ArrayList<Personne>();
		}
		return enfants;
	}

	public void setEnfants(List<Personne> enfants) {
		this.enfants = enfants;
	}

}

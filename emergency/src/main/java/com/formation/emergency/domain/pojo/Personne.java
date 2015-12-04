package com.formation.emergency.domain.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;

import com.formation.emergency.domain.pojo.feuilles.FeuilleSortie;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TypePersonne", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue(value="PERSONNE")
@NamedEntityGraphs({
    @NamedEntityGraph(
        name = "brancheMere",
        attributeNodes = {
            @NamedAttributeNode(value = "mere")
        }
    ),
    @NamedEntityGraph(
        name = "brancheChildren",
        attributeNodes = {
            @NamedAttributeNode(value = "enfants", subgraph = "sousGrapheFeuilleSortie")
        },
        subgraphs = {
            @NamedSubgraph(
                    name = "sousGrapheFeuilleSortie",
                    attributeNodes = {
                        @NamedAttributeNode(value = "feuilles")
                    }
            )
        }
    )
})
public class Personne {
		
	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String uuid;
		
	private Date dateNaissance;
	
	private String nom;
	
	private String prenom;
	
	@ManyToOne
	@JoinColumn
	private Personne mere;
	
	@ManyToOne
	@JoinColumn
	private Personne pere;
	
	@OneToMany(mappedBy="mere", cascade = {CascadeType.PERSIST, CascadeType.REMOVE} , orphanRemoval=true)
	private Set<Personne> enfants;
	  
//  (Cas 1)	-> La FK vers la personne est dans feuille de sortie
//	(Cas 2)	-> La reference est porté par une table personne_feuillesortie qui contient les primary keys de Personne et FeuilleSortie 
//	@OneToMany(mappedBy="personne", cascade=CascadeType.ALL)
	@OneToMany(cascade=CascadeType.ALL)
	private Set<FeuilleSortie> feuilles;
	
	public Personne() {
		this.enfants = new HashSet<Personne>();
	}
	
		
	public Personne(String nom, String prenom) {
		this();
		this.nom = nom;
		this.prenom = prenom;
	}


	public Integer getId() {
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
	
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public Set<Personne> getEnfants() {
		return enfants;
	}

	public void setEnfants(Set<Personne> enfants) {
		this.enfants = enfants;
	}
	
	public Set<FeuilleSortie> getFeuilles() {
		return feuilles;
	}

	public void setFeuilles(Set<FeuilleSortie> feuilles) {
		this.feuilles = feuilles;
	}
	
	@Override
	public String toString() {
		return nom + " " + prenom
			 + (mere != null ? "\nmere = " + mere : "")
			 + (pere != null ? "\npere = " + pere : "");
	}	
	
}

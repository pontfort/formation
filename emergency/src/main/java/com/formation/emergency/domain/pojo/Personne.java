package com.formation.emergency.domain.pojo;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="discriminator_personne",  discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue(value="PERSONNE")
@NamedEntityGraphs({
	@NamedEntityGraph(name="withMere",attributeNodes={@NamedAttributeNode("children")}),
	@NamedEntityGraph(name="withChildren", attributeNodes={
			@NamedAttributeNode(value="children", subgraph="withFeuillesSortie")
	},
	subgraphs={
			@NamedSubgraph(name="withFeuillesSortie", attributeNodes={
					@NamedAttributeNode("feuillesSorties")
			})
	})		
})
public class Personne {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nom;
	private String prenom;

	// TODO obligatoire
	private Date dateNaissance;
	@JoinColumn(name="mere_child")
	@ManyToOne(cascade=CascadeType.ALL)
	private Personne mere;
	
	@ManyToOne
	@JoinColumn(name="pere")
	private Personne pere;

	@OneToMany(mappedBy="mere", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	//@JoinColumn(name="mere_child")
	private List<Personne> children;
	
	@OneToMany(mappedBy="personne", cascade = CascadeType.ALL)
	private List<FeuilleSortie> feuillesSorties;
	//@Transient   // -->> ignoré par le mapping
	
	

	/**
	 * @return the children
	 */
	public List<Personne> getChildren() {
		return children;
	}

	/**
	 * @return the feuillesSorties
	 */
	public List<FeuilleSortie> getFeuillesSorties() {
		return feuillesSorties;
	}

	/**
	 * @param feuillesSorties the feuillesSorties to set
	 */
	public void setFeuillesSorties(List<FeuilleSortie> feuillesSorties) {
		this.feuillesSorties = feuillesSorties;
	}

	/**
	 * @param children the children to set
	 */
	public void setChildren(List<Personne> children) {
		this.children = children;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format("Personne [nom=%s, prenom=%s, dateNaissance=%s, mere=%s, pere=%s]", nom, prenom,
				dateNaissance, mere, pere);
	}

}

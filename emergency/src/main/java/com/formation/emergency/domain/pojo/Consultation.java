package com.formation.emergency.domain.pojo;

import javax.persistence.*;

@Entity
@DiscriminatorValue("CONSULATION")
public class Consultation extends FeuilleSortie {
	private String commentaire;

	/**
	 * @return the commentaire
	 */
	public String getCommentaire() {
		return commentaire;
	}

	/**
	 * @param commentaire the commentaire to set
	 */
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
}

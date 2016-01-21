package com.formation.emergency.domain.pojo.feuilles;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="ACTE")
public abstract class Acte extends FeuilleSortie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}

package com.formation.emergency.domain.pojo.feuilles;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="ACTESDECES")
public class ActeDeces extends Acte implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	@Override
//	public String toString() {
//		return "ActeDeces";
//	}
	
}

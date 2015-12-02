package com.formation.emergency.domain.pojo.feuilles;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="ACTESDECES")
public class ActeDeces extends Acte {

//	@Override
//	public String toString() {
//		return "ActeDeces";
//	}
	
}

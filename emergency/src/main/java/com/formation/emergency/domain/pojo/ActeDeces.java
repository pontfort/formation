package com.formation.emergency.domain.pojo;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ACTE_DECES")
public class ActeDeces extends Act {

	private Date dateDeDeces;

	public Date getDateDeDeces() {
		return dateDeDeces;
	}

	public void setDateDeDeces(Date dateDeDeces) {
		this.dateDeDeces = dateDeDeces;
	}

}

package com.formation.emergency.domain.pojo.equipement;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ambulance")
@DiscriminatorValue(value = "AMBULANCE")
public class Ambulance extends Equipement {

	private long km;

	public long getKm() {
		return km;
	}

	public void setKm(long km) {
		this.km = km;
	}

}

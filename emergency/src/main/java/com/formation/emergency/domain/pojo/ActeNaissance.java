package com.formation.emergency.domain.pojo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ACTENAISSANCE")
public class ActeNaissance extends Acte {

}

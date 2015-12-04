package com.formation.emergency.domain.pojo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ACTEDECES")
public class ActeDeces extends Acte {

}

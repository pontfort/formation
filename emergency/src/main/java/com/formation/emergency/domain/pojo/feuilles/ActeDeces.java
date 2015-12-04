package com.formation.emergency.domain.pojo.feuilles;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "ACTEDECES")
public class ActeDeces extends Acte {
}

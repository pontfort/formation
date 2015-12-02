package com.formation.emergency.domain.pojo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("FACTURE")
public class Facture extends FeuilleSortie {

}

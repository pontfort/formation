package com.formation.emergency.domain.dao.springrepo;

import java.util.Date;
import java.util.List;

import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.formation.emergency.domain.dao.repository.QueriesDictonary;
import com.formation.emergency.domain.pojo.Equipement;

public interface IEquipementJPA extends JpaRepository<Equipement, Integer> {
//cas 1 : query locale
	@Modifying
	@Query("UPDATE Equipement e SET e.disponible = :"+ QueriesDictonary.EQUIPEMENT_DISPONIBLE + " WHERE e.id = :" + QueriesDictonary.EQUIPEMENT_ID)
	void changerEtat(@Param(QueriesDictonary.EQUIPEMENT_DISPONIBLE)Boolean dispo, @Param(QueriesDictonary.EQUIPEMENT_ID)int id);
//cas 2 : named query
	@Modifying
	void supprimer(@Param(QueriesDictonary.EQUIPEMENT_ID)int id);
// cas 3 : query auto build
	List<Equipement> findByReferenceStartingWithAndReferenceContainingAndReferenceEndingWithAndDateAchatNotNullAndDateAchatBetweenAndPrixBetweenOrderByPrixDesc(String commencePar, String contient, String finiPar, Date dateVingtJour, Date dateDuJour, int prixMin, int prixMax);
	
	
	
}

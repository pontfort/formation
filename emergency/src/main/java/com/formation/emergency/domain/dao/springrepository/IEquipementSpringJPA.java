package com.formation.emergency.domain.dao.springrepository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.formation.emergency.domain.dao.repository.QueriesDictionary;
import com.formation.emergency.domain.pojo.Equipement;

public interface IEquipementSpringJPA extends JpaRepository<Equipement, Integer> {

	//Cas 1
	@Modifying
	@Query("UPDATE Equipement e SET e.reserve = :pReserve WHERE e.id = :pId")
	void changerDispo(@Param("pReserve") Boolean reserve, @Param("pId") Integer id);
	
	//Cas 2 - Utilisation du nameQuery Equipement.supprimer
	@Modifying
	void supprimer(@Param(QueriesDictionary.EQUIPEMENT_QUERY_PARAM_ID) Integer id);
	
	//Cas 3 - Query auto build
	List<Equipement> findByReferenceStartingWithAndReferenceContainingAndReferenceEndingWithAndDateAchatNotNullAndDateAchatBetweenAndPrixBetweenOrderByPrixDesc(String commencePar, String contient, String finiPar, Date dateVingtJour, Date dateDuJour, float prixMin, float prixMax);
	
}

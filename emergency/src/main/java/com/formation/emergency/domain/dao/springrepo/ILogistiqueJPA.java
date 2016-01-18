package com.formation.emergency.domain.dao.springrepo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.formation.emergency.domain.dao.repository.QueriesDictionary;
import com.formation.emergency.domain.pojo.Equipement;
import com.formation.emergency.domain.pojo.EtatEquipement;

public interface ILogistiqueJPA extends JpaRepository<Equipement, Integer> {

	@Query("UPDATE Equipement e SET " + "e.reserve = :" + QueriesDictionary.EQUIPEMENT_QUERY_PARAM_RESERVE + ","
			+ "e.etat = :" + QueriesDictionary.EQUIPEMENT_QUERY_PARAM_ETAT + " WHERE e.id = :"
			+ QueriesDictionary.EQUIPEMENT_QUERY_PARAM_ID)
	void updateEtat(@Param("pReserve") Boolean reserve, @Param("pEtat") EtatEquipement etat, @Param("pId") Integer id);

	@Modifying
	void supprimer(@Param("pId") Integer id);

	List<Equipement> findByReferenceStartingWithAndReferenceContainingAndReferenceEndingWithAndDateAchatIsNotNullAndDateAchatBetweenAndPriceBetweenOrderByPriceDesc(
			String refStart, String refContain, String refEnding, Date startDate, Date endingDate, int priceMin,
			int priceMax);

}

package com.formation.emergency.domain.daoSpringRepo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.formation.emergency.domain.dao.QueriesDictionary;
import com.formation.emergency.domain.pojo.Equipement;
import com.formation.emergency.domain.pojo.code.TypeEquipement;

public interface IEquipementJPA extends JpaRepository<Equipement, Integer> {
	
	// cas 1 : query locale
	@Query("Update Equipement e SET e.type = :type WHERE e.id = :id")
	void changerEtat(@Param("type")TypeEquipement disponible, @Param("id")Integer id);
	
	// cas 2 : named query
	@Modifying
	void supprimer( @Param(QueriesDictionary.EQUIPEMENT_QUERYPARAM_ID)Integer id);
	
	// cas 3 : query auto build
	
	List<Equipement> findByReferenceStartingWithAndReferenceContainingAndReferenceEndingWithAndDateAchatNotNullAndDateAchatAfterAndPrixBetweenOrderByPrix
		(String sarting, String containing, String ending, Date dateachat,int prixmin, int prixmax);
	
	
	/*List<Equipement> findByReferenceStartingWithAndReferenceContainingAndReferenceEndingWithAndDateAchatIsNotNullAndDateAchatBetweenAndPriceBetweenOrderByPriceDesc(
			String refStart, String refContain, String refEnding, Date startDate, Date endingDate, int priceMin,
			int priceMax);*/ 
}

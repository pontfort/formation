package com.formation.emergency.domain.dao.springrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

import com.formation.emergency.domain.dao.repository.QueriesDictionary;
import com.formation.emergency.domain.pojo.Patient;
import com.formation.emergency.domain.pojo.code.EtatPatient;

public interface IPatientSpringJPA extends JpaRepository<Patient, Integer> {
	
	@Modifying
	void updateEtat(@Param(QueriesDictionary.PATIENT_QUERY_PARAM_ETAT) EtatPatient newEtat, @Param(QueriesDictionary.PATIENT_QUERY_PARAM_ID) Integer id);
}

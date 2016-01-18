package com.formation.emergency.domain.dao.springrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

import com.formation.emergency.domain.dao.repository.QueriesDictionary;
import com.formation.emergency.domain.pojo.Patient;
import com.formation.emergency.domain.pojo.code.EtatPatient;

public interface IPatientJPA extends JpaRepository<Patient, Integer> {

	@Modifying
	public void updateEtat(@Param(QueriesDictionary.EQUIPEMENT_QUERY_PARAM_ETAT) EtatPatient etat,
			@Param(QueriesDictionary.PATIENT_QUERY_PARAM_ID) Integer id);

}

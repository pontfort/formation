package com.formation.emergency.domain.daoSpringRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

import com.formation.emergency.domain.dao.QueriesDictionary;
import com.formation.emergency.domain.pojo.Patient;

public interface IPatientJPA extends JpaRepository<Patient, Integer> {
	@Modifying
	void updateNumSecu(@Param(QueriesDictionary.PATIENT_QUERYPARAM_NUMSECU) String numSecu,
			@Param(QueriesDictionary.PATIENT_QUERYPARAM_ID) int id);
}

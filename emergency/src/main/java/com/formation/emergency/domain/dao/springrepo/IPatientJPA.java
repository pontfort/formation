package com.formation.emergency.domain.dao.springrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

import com.formation.emergency.domain.pojo.EtatPatient;
import com.formation.emergency.domain.pojo.Patient;
import com.formation.emergency.domain.dao.repository.QueriesDictonary;

public interface IPatientJPA extends JpaRepository<Patient, Integer> {
	@Modifying
	void updateEtat(@Param(QueriesDictonary.PATIENT_ETAT)EtatPatient etat, @Param(QueriesDictonary.PATIENT_ID)int id);
}

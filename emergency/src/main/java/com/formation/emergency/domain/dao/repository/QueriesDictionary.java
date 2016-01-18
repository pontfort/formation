package com.formation.emergency.domain.dao.repository;

public interface QueriesDictionary {
	
	public static final String PATIENT_UPDATE = "Patient.update";
	public static final String PATIENT_UPDATE_ETAT = "Patient.updateEtat";
	public static final String PATIENT_DELETE = "Patient.delete";

	public static final String PATIENT_QUERY_PARAM_NOM = "pNom";
	public static final String PATIENT_QUERY_PARAM_PRENOM = "pPrenom";
	public static final String PATIENT_QUERY_PARAM_ETAT = "pEtat";
	public static final String PATIENT_QUERY_PARAM_SECU = "pSecu";
	public static final String PATIENT_QUERY_PARAM_ID = "pId";

	public static final String EQUIPEMENT_UPDATE = "Equipement.update";
	public static final String EQUIPEMENT_DELETE = "Equipement.supprimer";

	public static final String EQUIPEMENT_QUERY_PARAM_NOM = "pNom";
	public static final String EQUIPEMENT_QUERY_PARAM_REFERENCE = "pReference";
	public static final String EQUIPEMENT_QUERY_PARAM_ETAT = "pEtat";
	public static final String EQUIPEMENT_QUERY_PARAM_RESERVE = "pReserve";

	public static final String EQUIPEMENT_QUERY_PARAM_ID = "pId";

}

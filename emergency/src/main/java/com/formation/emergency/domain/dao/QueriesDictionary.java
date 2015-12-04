package com.formation.emergency.domain.dao;

public interface QueriesDictionary {

	public static final String PATIENT_UPDATE = "patient.update";
	public static final String PATIENT_UPDATE_ETAT = "patient.update.etat";
	public static final String PATIENT_DELETE = "patient.delete";	
	
	public static final String PATIENT_QUERY_PARAM_NOM = "pNom";
	public static final String PATIENT_QUERY_PARAM_PRENOM = "pPrenom";
	public static final String PATIENT_QUERY_PARAM_ETAT = "pEtat";
	public static final String PATIENT_QUERY_PARAM_SECU = "pSecu";
	public static final String PATIENT_QUERY_PARAM_ID = "pId";
	
	public static final String EQUIPEMENT_UPDATE = "equipement.update";
	public static final String EQUIPEMENT_DELETE = "equipement.delete";
	
	public static final String EQUIPEMENT_QUERY_PARAM_NOM = "pNom";
	public static final String EQUIPEMENT_QUERY_PARAM_REFERENCE = "pReference";
	public static final String EQUIPEMENT_QUERY_PARAM_ETAT = "pEtat";
	public static final String EQUIPEMENT_QUERY_PARAM_RESERVE = "pReserve";
	
	public static final String EQUIPEMENT_QUERY_PARAM_ID = "pId";
	
}

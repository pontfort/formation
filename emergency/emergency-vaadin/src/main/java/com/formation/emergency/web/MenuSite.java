package com.formation.emergency.web;

public enum MenuSite {
	
	ACCUEIL("menu.home"),
	LOGISTIQUE("menu.logistic");
	
	private final String keyLabel;
	
	private MenuSite(String label){
		keyLabel = label;
	}
	
	public String getKeyLabel(){
		return keyLabel;
	}
}

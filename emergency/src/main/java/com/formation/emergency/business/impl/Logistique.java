package com.formation.emergency.business.impl;

import com.formation.emergency.business.ILogistique;
import com.formation.emergency.domain.pojo.Equipement;
import com.formation.emergency.exception.IndisponibiliteExpection;

public class Logistique implements ILogistique {

	@Override
	public void acheter(Equipement equipement) throws IndisponibiliteExpection {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reparer(Equipement equipement) throws IndisponibiliteExpection {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void retirer(Equipement equipement) throws IndisponibiliteExpection {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Equipement mettreADisposition(String reference) throws IndisponibiliteExpection {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void recuperer(Equipement equipement) throws IndisponibiliteExpection {
		// TODO Auto-generated method stub
		
	}

}

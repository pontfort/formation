package com.formation.emergency.domain.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.formation.emergency.domain.pojo.Equipement;

public class LogitiqueDAOJpa extends GenericRepository implements IRepository<Equipement> {

	public void create(Equipement object) {
		this.getEm().persist(object);
			}

	@Override
	public void update(Equipement object) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(Object object) {
			Query q = getEm().createNamedQuery(QueriesDictionary.EQUIPEMENT_DELETE);
			q.setParameter(QueriesDictionary.EQUIPEMENT_QUERYPARAM_ID, object);
			q.executeUpdate();
	}

	@Override
	public Equipement find(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Equipement> findall() {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.formation.emergency.domain.dao;

import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import com.formation.emergency.domain.pojo.Equipement;

@Repository("equipementDao")
public class EquipementDao extends GenericRepository implements IRepository<Equipement> {

	public EquipementDao() {
		super();
	}

	@Override
	public Equipement read(Object key) {
		return this.getEm().find(Equipement.class, key);
	}

	@Override
	public void update(Equipement equipement) {	
			Query query = this.getEm().createNamedQuery(QueriesDictionary.EQUIPEMENT_UPDATE);

			// Query query = em.createQuery("Update Patient p SET p.nom :pNom where p.id= :pId");
			
			//query.setParameter(QueriesDictionary.PATIENT_PARAM_NUMERO_SECU, equipement.getPaysOrigine());
			//query.setParameter(QueriesDictionary.PARAM_ID, equipement.getReference());
			query.executeUpdate();
	}

	@Override
	public void delete(Object key) {
			Query query = em.createNamedQuery(QueriesDictionary.PATIENT_DELETE);
			// Query query = em.createQuery("Delete FROM Patient p where
			// p.numeroSecu='" + key + "'");
			query.setParameter(QueriesDictionary.PATIENT_PARAM_NUMERO_SECU, key);
			System.out.println(query.toString());
			query.executeUpdate();
	}

	@Override
	public List<Equipement> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

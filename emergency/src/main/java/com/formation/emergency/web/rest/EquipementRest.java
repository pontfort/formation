package com.formation.emergency.web.rest;

import java.io.Serializable;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.emergency.domain.dao.springrepo.ILogistiqueJPA;
import com.formation.emergency.domain.pojo.Equipement;

@Path("/")
@Service(value = "equipementRest")
@Produces({ MediaType.APPLICATION_JSON })
public class EquipementRest implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ILogistiqueJPA logistique;

	public EquipementRest() {
		// TODO Auto-generated constructor stub
	}

	@POST
	public void createOrUpdate(Equipement equipement) {
		logistique.saveAndFlush(equipement);
	}

	@GET
	@Produces({ MediaType.APPLICATION_ATOM_XML, MediaType.APPLICATION_JSON })
	public List<Equipement> findAll() {
		return logistique.findAll();
	}

	@GET
	@Path("/{id}")
	public Equipement find(@PathParam("id") Integer id) {
		return logistique.findOne(id);
	}

	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") Integer id) {
		logistique.delete(id);
	}

	@PUT
	public void update(Equipement equipement) {
		logistique.saveAndFlush(equipement);
	}

}

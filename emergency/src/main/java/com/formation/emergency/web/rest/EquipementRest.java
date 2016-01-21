package com.formation.emergency.web.rest;

import java.util.List;

import javax.ws.rs.Consumes;
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
import com.formation.emergency.domain.dao.springrepo.IEquipementJPA;
import com.formation.emergency.domain.pojo.Equipement;

@Service("equipementRest")
@Path("/")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class EquipementRest {

	@Autowired
	IEquipementJPA equipementJpa;

	@POST
	public void create(Equipement equipement) {
		equipementJpa.saveAndFlush(equipement);
	}

	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Equipement> findAll() {
		return equipementJpa.findAll();
	}

	@GET
	@Path("/{reference}")
	public Equipement find(@PathParam("reference") int reference) {
		return equipementJpa.findOne(reference);
	}

	@DELETE
	@Path("/{reference}")
	public void delete(@PathParam("reference") int reference) {
		equipementJpa.delete(reference);
	}
	
	@PUT
	@Path("/{reference}")
	public void update(@PathParam("reference") Equipement equipement) {
		equipementJpa.saveAndFlush(equipement);
	}
}

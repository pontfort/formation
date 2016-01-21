package com.formation.emergency.web.spring;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.formation.emergency.business.ILogistique;
import com.formation.emergency.domain.pojo.Equipement;

@Controller
@RequestMapping("/equipement")
public class EquipementController {

	@Autowired
	ILogistique logistique;

	@RequestMapping(path = { "/list" }, method = RequestMethod.GET)
	public String findAll(ModelMap model) {

		model.addAttribute("equipements", logistique.findAll());

		return "accueil";
	}

	@RequestMapping(path = { "/{id}/{action}" }, method = RequestMethod.GET)
	public String delete(ModelMap model, @PathVariable("id") Integer id, @PathVariable("action") String action) {

		try {
			switch (action) {
			case "delete": {
				logistique.retirer(id);
				break;
			}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("equipements", logistique.findAll());

		return "accueil";
	}

	@RequestMapping(path = { "/create" }, method = RequestMethod.POST)
	public String create(ModelMap model, @ModelAttribute("equipement") @Valid Equipement equipement,
			BindingResult result) {

		try {
			logistique.acheter(equipement);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("equipements", logistique.findAll());

		return "accueil";
	}

	@RequestMapping(path = { "/listtoutformat" }, method = RequestMethod.GET, produces = { 
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> listtoutformat(ModelMap model, HttpServletResponse response) {

		try {
			throw new Exception("ca c'est mal passé !");
			//return ResponseEntity.ok().body(logistique.findAll());
		} catch (Exception ex) {
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
	}
}

package com.formation.emergency.web.spring;

import java.util.List;

import javax.print.attribute.standard.Media;
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
public class HelloController {

	@Autowired
	ILogistique logistique;
	
	@RequestMapping(path="/list",method=RequestMethod.GET)
	public String findAll(ModelMap model) {
		model.addAttribute("results", logistique.getAll());
		return "results";
	}
	
	@RequestMapping(path="/{id}/{action}",method=RequestMethod.GET)
	public String delete(ModelMap model, @PathVariable("id") int id, @PathVariable("action") String action) {
		Equipement equipement = logistique.getById(id);
		try{
			switch (action) {
			case "delete":
				logistique.retirer(equipement);
				break;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		model.addAttribute("results", logistique.getAll());
		return "results";
	}
	
	@RequestMapping(path="/create",method=RequestMethod.POST)
	public String create(ModelMap model, @ModelAttribute("equipement") @Valid Equipement equipement, BindingResult result) {
		try {
			logistique.acheter(equipement);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("results", logistique.getAll());
		return "results";
	}
	
	@RequestMapping(path="/listtoutformat",method=RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_XML_VALUE})
	@ResponseBody
	public ResponseEntity<?> listtoutformat(ModelMap model, HttpServletResponse response) {
		try {
			return ResponseEntity.ok().body(logistique.getAll());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}

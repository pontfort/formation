package com.formation.emergency.web.spring;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

	private final static String ACTION_DELETE = "delete";

	@Autowired
	ILogistique logistique;

	@RequestMapping(path = "/list")
	public String getListEquipementPage(Model m) {
		m.addAttribute("equipements", logistique.findAll());
		return "gestionequipements3";
	}

//	@InitBinder
//	private void dateBinder(WebDataBinder binder) {
//
//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//		dateFormat.setLenient(false);
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
//
//	}

	@RequestMapping(path = "/{id}/{action}", method = RequestMethod.GET)
	public String performAction(Model m, @PathVariable("id") int idEquipement, @PathVariable("action") String action) {

		try {

			switch (action) {
			case ACTION_DELETE:
				this.logistique.retirer(idEquipement);
				break;
			default:
				break;
			}

			m.addAttribute("equipements", logistique.findAll());
			return "gestionequipements3";

		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	@RequestMapping(path = "/create", method = RequestMethod.POST)
	public String createEquipement(Model m, @ModelAttribute("equipement") @Valid Equipement e, BindingResult result) {

		try {
			this.logistique.acheter(e);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		m.addAttribute("equipements", logistique.findAll());
		return "gestionequipements3";
	}

	@RequestMapping(path = "/listtoutformat", method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_UTF8_VALUE})
	@ResponseBody
	public ResponseEntity<?> listToutFormat(Model m) {

		try {
			throw new Exception("C'est la merde");
//			return ResponseEntity.ok().body(logistique.findAll());			
		}
		catch (Exception ex) {
			return ResponseEntity.badRequest().body(ex);	
		}		
		
	}

}

package com.formation.emergency.web.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.formation.emergency.business.ILogistique;
import com.formation.emergency.domain.pojo.Equipement;
import com.formation.emergency.exception.IndisponibiliteException;

@Controller
@RequestMapping("/equipement")
public class HelloController {

	@Autowired
	ILogistique logistique;

	@RequestMapping(path = "/list", method = RequestMethod.GET)
	public String printHello(ModelMap model) {
		model.addAttribute("results", logistique.FindAll());

		return "findresults";
	}

	// @RequestMapping(path="/{id}/delete")
	@RequestMapping(path = "/{id}/{action}")
	public String delete(ModelMap model, @PathVariable("id") Integer id, @PathVariable("action") String action)
			throws IndisponibiliteException {
		if (action.equals("delete")) {
			Equipement eq = logistique.getById(id);
			logistique.retirer(eq);
		}
		return "acceuil";
	}

	@RequestMapping(path = "/listtoutformat", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public List<Equipement> listtoutformat(ModelMap model) {
		return logistique.FindAll();

	}

	@RequestMapping(path = "/listtoutformatwithresponseentity", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<Equipement>> listtoutformatwithresponseentity(ModelMap model) {
		return ResponseEntity.accepted().body(logistique.FindAll());
	}

	@RequestMapping(path = "/listtoutformatwithresponseentityxml", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public ResponseEntity<List<Equipement>> listtoutformatwithresponseentityxml(ModelMap model) {
		return ResponseEntity.ok().body(logistique.FindAll());
	}

	@RequestMapping(path = "/failedlisttoutformatwithresponseentity", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<?> failedlisttoutformatwithresponseentity(ModelMap model) {
		return ResponseEntity.badRequest().body("Erreur de format xml");
	}

	@RequestMapping(path = "/listtoutformatwithresponseentitywitherror", method = RequestMethod.GET, produces ={ MediaType.APPLICATION_JSON_UTF8_VALUE,MediaType.TEXT_XML_VALUE})
	@ResponseBody
	public ResponseEntity<?> listtoutformatwithresponseentitywitherror(ModelMap model) {
		try {
			throw new Exception("qsdlkjhgqskjhdgqkjhsgd");
			//return ResponseEntity.accepted().body(logistique.FindAll());
		} catch (Exception ex) {
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
	}
}

package com.formation.emergency.web;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.emergency.business.ILogistique;
import com.formation.emergency.domain.pojo.Equipement;

/**
 * Servlet implementation class GestionEquipement
 */
@WebServlet(name = "gestionEquipement", urlPatterns = { "/gestione" })
public class GestionEquipement extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
		
	ILogistique logistique = null;
	ClassPathXmlApplicationContext context;

    /**
     * Default constructor. 
     */
    public GestionEquipement() {
    }
    
    @Override
    public void init() throws ServletException {
    	this.context = new ClassPathXmlApplicationContext("emergency.xml");
		this.logistique = (ILogistique) context.getBean("logistique");
    	super.init();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {				
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
						
		String ref = request.getParameter("reference");
		
		if (ref != null) {
		
			String nom = request.getParameter("nom");			
			Date dateAchat = Date.valueOf(request.getParameter("date_achat"));
	
			Equipement newEquip = new Equipement();
			newEquip.setReference(ref);
			newEquip.setNom(nom);
			newEquip.setDateAchat(dateAchat);
			
			try {
				this.logistique.acheter(newEquip);			
//				response.getWriter().append("Nouveau ID : " + newEquip.getId());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				response.getWriter().append(e.getMessage());
			}
				
		}
					
		List<Equipement> result = this.logistique.findAll();			
		request.setAttribute("equipements", result);						
		request.getRequestDispatcher("/gestionequipements3.jsp").forward(request, response);		
		
																	
	}
	
	private void DeleteEquip(Integer id) {		
		try {
			this.logistique.retirer(id);
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

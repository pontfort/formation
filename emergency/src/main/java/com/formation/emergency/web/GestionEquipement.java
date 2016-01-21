package com.formation.emergency.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.emergency.business.ILogistique;
import com.formation.emergency.domain.pojo.Equipement;

/**
 * Servlet implementation class GestionEquipement
 */
@WebServlet(name = "ge", urlPatterns = { "/ge" })
public class GestionEquipement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ApplicationContext context = null;
	ILogistique logistique = null;

	@Override
	public void init() throws ServletException {
		this.context = new ClassPathXmlApplicationContext("emergency.xml");
		this.logistique = (ILogistique) context.getBean("logistique");
		super.init();
	}

	/**
	 * Default constructor.
	 */
	public GestionEquipement() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		try {
			if (id != null && !id.isEmpty())
				logistique.retirer(Integer.valueOf(id.trim()));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<Equipement> equipements = logistique.findAll();
		request.setAttribute("equipements", equipements);
		request.getRequestDispatcher("/accueil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ref = request.getParameter("reference");
		String dateAchatParam = request.getParameter("dateAchat");
		String reserveParam = request.getParameter("reserve");

		Date dateAchat = new Date();
		try {
			if (dateAchatParam != null)
				dateAchat = new SimpleDateFormat("yyyy-MM-dd").parse(dateAchatParam);
		} catch (ParseException e) {
		}

		Equipement equipement = new Equipement(ref, "Equip" + Math.random());
		equipement.setDateAchat(dateAchat);
		equipement.setReserve(reserveParam.equals("oui") ? true : false);

		try {
			logistique.acheter(equipement);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<Equipement> equipements = logistique.findAll();

		request.setAttribute("equipements", equipements);
		request.getRequestDispatcher("/acceuil.jsp").forward(request, response);
	}

}

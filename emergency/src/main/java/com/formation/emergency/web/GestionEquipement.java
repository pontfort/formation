package com.formation.emergency.web;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
@WebServlet("/gestionequipement")
public class GestionEquipement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ILogistique logistique = null;
	ClassPathXmlApplicationContext context = null;

	/**
	 * Default constructor.
	 */
	public GestionEquipement() {
		context = new ClassPathXmlApplicationContext("emergency.xml");
		logistique = (ILogistique) context.getBean("logistique");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("enter doGet: ").append(request.getParameter("nom"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Calendar d = Calendar.getInstance();
		d.add(Calendar.DAY_OF_YEAR, -20);
		String sarting = "";// request.getParameter("");
		String containing = request.getParameter("reference");
		String ending = "";// request.getParameter("");
		Date dateachat = d.getTime();
		int prixmin = Integer.parseInt(request.getParameter("prix"));
		prixmin = prixmin - 10;
		int prixmax = prixmin + 20;
		
		/*
		 * response.getWriter().append(Integer.toString(
		 * this.logistique.getbyCriteria(sarting, containing, ending, dateachat,
		 * prixmin, prixmax).size()));
		 */

		request.setAttribute("results", this.logistique.getbyCriteria(sarting, containing, ending, dateachat,		 prixmin, prixmax));
		
		RequestDispatcher disp = request.getRequestDispatcher("findresults.jsp");

		disp.forward(request, response);

		/*
		 * Object ref = request.getSession().getAttribute("prenom");
		 * response.getWriter().append((ref == null ? "pad de ref" : (String)
		 * ref));
		 * 
		 * // TODO Auto-generated method stub // doGet(request, response);
		 * response.getWriter().append("   enter doPost: "
		 * ).append(request.getParameter("prenom"));
		 * request.getSession().setAttribute("prenom",
		 * request.getParameter("prenom"));
		 */
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

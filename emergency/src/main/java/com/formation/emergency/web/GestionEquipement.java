package com.formation.emergency.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "gestione", urlPatterns = { "/gestione" })
public class GestionEquipement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ILogistique logistique = null;

    /**
     * Default constructor. 
     */
    public GestionEquipement() {
    }    	
    @Override
    public void init() throws ServletException {
    	super.init();
    	ApplicationContext app = new ClassPathXmlApplicationContext("azam.xml");
    	logistique = (ILogistique) app.getBean("logistique");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("yoyo man: ").append(request.getParameter("reference"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*Object ref = request.getSession().getAttribute("reference");
		response.getWriter().append(ref == null ? "pas de ref..." : (String)ref);
		response.getWriter().append("yoyo POST: ").append(request.getParameter("reference"));
		request.getSession().setAttribute("reference", request.getParameter("reference"));*/
		
		String startWith = request.getParameter("startWith");
		String contain = request.getParameter("contain");
		String endWith = request.getParameter("endWith");
		
		Calendar today = Calendar.getInstance();
		Date dateachatMax = today.getTime();
		today.add(Calendar.DAY_OF_YEAR, -20);
		Date dateachatMin = today.getTime();
		
		int prixMax = Integer.parseInt(request.getParameter("prixMax"));
		int prixMin = Integer.parseInt(request.getParameter("prixMin"));
		
		List<Equipement> liste = this.logistique.rechercheCustom(startWith, contain, endWith, dateachatMin, dateachatMax, prixMin, prixMax);
		request.setAttribute("results", liste);
		
		RequestDispatcher disp = request.getRequestDispatcher("results.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

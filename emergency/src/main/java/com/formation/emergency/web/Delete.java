package com.formation.emergency.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.emergency.business.ILogistique;
import com.formation.emergency.domain.pojo.Equipement;
import com.formation.emergency.exception.IndisponibiliteException;

/**
 * Servlet implementation class Delete
 */
@WebServlet(name = "delete", urlPatterns = { "/delete" })
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ILogistique logistique = null;
	ClassPathXmlApplicationContext context = null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();
    	context = new ClassPathXmlApplicationContext("emergency.xml");
		logistique = (ILogistique) context.getBean("logistique");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer eqId = Integer.parseInt(request.getParameter("id"));
		
		Equipement eq = logistique.getById(eqId);
		try {
			logistique.retirer(eq);
		} catch (IndisponibiliteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("results", this.logistique.FindAll());
		
		request.getRequestDispatcher("findresults.jsp").forward(request, response);
	}

}

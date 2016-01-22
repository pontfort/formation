package com.formation.emergency.web;

import java.io.IOException;
import java.util.List;

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
import com.formation.emergency.exception.IndisponibiliteException;

/**
 * Servlet implementation class Delete
 */
@WebServlet(name = "delete", urlPatterns = { "/delete" })
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ILogistique logistique = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();
        ApplicationContext app = new ClassPathXmlApplicationContext("azam.xml");
    	logistique = (ILogistique) app.getBean("logistique");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Equipement equipement = this.logistique.getById(Integer.parseInt(id));
		try {
			logistique.retirer(equipement);
		} catch (IndisponibiliteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Equipement> liste = this.logistique.getAll();
		request.setAttribute("results", liste);
		
		RequestDispatcher disp = request.getRequestDispatcher("results.jsp");
		disp.forward(request, response);
	}

}

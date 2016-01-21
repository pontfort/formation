package com.formation.emergency.web;

import java.io.IOException;
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
@WebServlet(name = "login", urlPatterns = { "/login" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ApplicationContext context = null;
	ILogistique logistique = null;

	@Override
	public void init() throws ServletException {
		this.context = new ClassPathXmlApplicationContext("emergency.xml");
		this.logistique = (ILogistique) context.getBean("logistique");
		super.init();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getSession().invalidate();
		req.getSession().setAttribute("connected", false);
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getSession().setAttribute("connected", true);

		List<Equipement> equipements = logistique.findAll();
		request.setAttribute("equipements", equipements);
		request.getRequestDispatcher("/accueil.jsp").forward(request, response);
	}

}

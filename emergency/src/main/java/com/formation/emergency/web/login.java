package com.formation.emergency.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
@WebServlet(name = "login", urlPatterns = { "/login" })
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final static String LOGIN_SUCCESS = "jean";
	private final static String MOTDEPASSE_SUCCESS = "1234";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public login() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Object login = request.getParameter("login");
		Object motDePasse = request.getParameter("motDePasse");

		if (login == null) {
			response.getWriter().append("Champ 'login' manquant");
		} else if (motDePasse == null) {
			response.getWriter().append("Champ 'mot de passe' manquant");
		} else if (!LOGIN_SUCCESS.equals(login) || ! MOTDEPASSE_SUCCESS.equals(motDePasse)) {
			response.getWriter().append("Login ou mot de passe incorrect. Connection refus�e");
		} else {

			request.getSession().setAttribute("connected", true);

//			response.sendRedirect("new_equipement.jsp");
			response.sendRedirect("gestione");

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

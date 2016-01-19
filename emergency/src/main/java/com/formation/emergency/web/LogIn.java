package com.formation.emergency.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogIn
 */
@WebServlet("/login")
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogIn() {
		super();
		// TODO Auto-generated constructor stub
	}

	static final String UserName = "user";
	static final String Password = "000";

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestedUserName = request.getParameter("username");
		String requestedPassword = request.getParameter("password");
		response.getWriter().append(requestedUserName);
		response.getWriter().append("-+---------------");
		response.getWriter().append(requestedPassword);
		if (requestedUserName == null) {
			response.getWriter().append("Missing UserName");
			return;
		}
		if (requestedPassword == null) {
			response.getWriter().append("Missing Password");
			return;
		}

		if(requestedPassword.equals(Password) && requestedUserName.equals(UserName)){
			response.sendRedirect("form.html");	
		}else{
			response.getWriter().append("Wrong UserName and/or Password");
		}
		
	}

}

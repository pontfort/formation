package com.formation.emergency.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet(name = "login", urlPatterns = { "/login" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    final static String username = "aazam";
    final static String password = "pass";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String action = request.getParameter("action");
    	if(action.equals("logout")){
    		request.getSession().setAttribute("loggedin", false);
    	}
    	response.sendRedirect("acceuil.jsp");
	}
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reqLogin = request.getParameter("login");
		String reqPwd = request.getParameter("pwd");
		if(!reqLogin.equals(username)){
			response.getWriter().append("Wrong login.");
		}
		else if(!reqPwd.equals(password)){
			response.getWriter().append("Wrong password.");
		}
		else{
			request.getSession().setAttribute("loggedin", true);
			response.sendRedirect("form.html");
		}
	}

}

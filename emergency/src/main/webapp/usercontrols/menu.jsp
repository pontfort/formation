<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<c:choose>
	<c:when test="${loggedin}">
		<a href="acceuil.jsp?action=logout">Log-Out</a>
	</c:when>
	
	<c:otherwise>
		<a href="acceuil.jsp">Log-In</a>
	</c:otherwise>
</c:choose>

<hr>
<span>Session : <%=request.getSession().getId() %></span>
<div></div>
		<a href="acceuil.jsp">Accueil</a>
<hr>
<hr>
<hr>
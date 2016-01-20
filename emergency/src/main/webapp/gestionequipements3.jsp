
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.formation.emergency.domain.pojo.Equipement"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion des équipements</title>
</head>
<body>	

<%-- 	Session ID : <c:out value="${pageContext.session.id}"></c:out> --%>

	<jsp:include page="menu.jsp"></jsp:include>		
	
	<c:if test="${equipements != null && equipements.size() > 0}">
   	
		<h1>Liste des equipements</h1>			
	
		<jsp:include page="equipements.jsp"></jsp:include>
	
	</c:if>

	<h1>Nouvel equipement</h1>

	<form method="post" action="/emergency/spring/equipement/create">

		<div>
			Reference : <input type="text" name="reference">
		</div>
		<div>
			Nom : <input type="text" name="nom">
		</div>
		<div>
			Date achat : <input type="date" name="dateAchat">
		</div>

		<div>
			<input type="submit" value="Creer">
		</div>

	</form>
	
</body>
</html>
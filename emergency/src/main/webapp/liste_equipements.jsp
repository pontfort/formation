<%@page import="com.formation.emergency.domain.pojo.Equipement"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des equipements</title>
</head>
<body>

	<% 
	
	List<Equipement> result = ((List<Equipement>)request.getAttribute("equipements")); 
	
	%>
	<table>
		<tr>
		<td>Reference</td>
		<td>Nom</td>
		<td>Date d'achat</td>
		</tr>
		
	<%
	for (Equipement item : result) {
		%>
		<tr>
		<td><%=item.getReference() %></td>
		<td><%=item.getNom() %></td>
		<td><%=item.getDateAchat() %></td>
		</tr>
		<%
	}
	%>
	
	</table>
	
</body>
</html>
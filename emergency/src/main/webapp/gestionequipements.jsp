<%@page import="com.formation.emergency.domain.pojo.Equipement"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion des équipements</title>
</head>
<body>

	<%
		List<Equipement> result = ((List<Equipement>) request.getAttribute("equipements"));

		if (result != null && result.size() != 0) {
	%>

		<h1>Liste des equipements</h1>

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
				<td><%=item.getReference()%></td>
				<td><%=item.getNom()%></td>
				<td><%=item.getDateAchat()%></td>
			</tr>
		<%
			}
		%>
		</table>

	<%
		}
	%>

	<h1>Nouvel equipement</h1>

	<form method="post" action="gestione">

		<div>
			Reference : <input type="text" name="reference">
		</div>
			<div>
			Nom : <input type="text" name="nom">
		</div>
		<div>
			Date achat : <input type="date" name="date_achat">
		</div>

		<div>
			<input type="submit" value="Creer">
		</div>

	</form>
</body>
</html>
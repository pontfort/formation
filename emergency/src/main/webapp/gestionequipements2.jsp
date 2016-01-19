
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

	<h1>Liste des equipements</h1>


	<table>
		<c:forEach items="${equipements}" var="equip">
			<tr>
				<td>${equip.reference}</td>
				<td>${equip.dateAchat}</td>
				<td><a href="/emergency/ge?id=${equip.id}">Supprimer</a></td>
			</tr>
		</c:forEach>
	</table>


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
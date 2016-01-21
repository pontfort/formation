<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvenue</title>
</head>
<body>

	<h2>Bienvenue avec ta session : ${request.getSession().getId()}</h2>
	<a href="/emergency/login">Logout</a>
	<br />
	<br />

	<form method="POST" action="/emergency/spring/equipement/create">
		Reference:<br> <input type="text" name="reference" value="Ma ref"><br>
		Date achat :<br> <input type="date" name="dateAchat"
			value="2016/01/18"><br> <input type="radio"
			name="reserve" value="true" id="oui" checked="checked" /> <label
			for="oui" class="inline">oui</label> <input type="radio"
			name="reserve" value="false" id="non" /> <label for="non"
			class="inline">non</label> <br> <input type="submit"
			value="Créer un équipement">
	</form>

	<table>
		<c:forEach items="${equipements}" var="equip">
			<tr>
				<td>${equip.reference}</td>
				<td>${equip.dateAchat}</td>
				<td>${equip.reserve}</td>
				<!--  		<td><a href="/emergency/ge?id=${equip.id}">Supprimer</a></td> -->
				<td><a href="/emergency/spring/equipement/${equip.id}/delete">Supprimer</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>
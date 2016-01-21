<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="com.formation.emergency.domain.pojo.Equipement,java.util.List"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resultats de la recherche</title>
</head>
<body>
	<jsp:include page="/menu.jsp"></jsp:include>
	<table><tr><td>
		<table>
			<tr>
				<td>Ref</td>
				<td>Prix</td>
				<td>Date Achat</td>
				<td>Pays</td>
				<td>Dispo</td>
				<td>Action</td>
			</tr>
			<c:forEach items="${results}" var="e">
				<tr>
					<td><c:out value="${e.reference}"></c:out></td>
					<td><c:out value="${e.prix}"></c:out></td>
					<td><c:out value="${e.dateAchat}"></c:out></td>
					<td><c:out value="${e.paysOrigine}"></c:out></td>
					<td><c:out value="${e.disponible}"></c:out></td>
					<td><a href="/emergency/spring/equipement/${e.id}/delete">Supprimer</a></td>
				</tr>
			</c:forEach>
		</table>
		</td><td>
		<form action="/emergency/spring/equipement/create" method="POST">
			<table>
				<tr>
					<td>Reference : </td>
					<td colspan="2"><input type="text" name="reference" required></td>
				</tr>
				<tr>
					<td>Pays Origine : </td>
					<td colspan="2"><input type="text" name="paysOrigine"></td>
				</tr>
				<tr>
					<td>Prix : </td>
					<td colspan="2"><input type="number" name="prix"></td>
				</tr>
				<tr>
					<td>Date Achat : </td>
					<td colspan="2"><input type="date" name="dateAchat"></td>
				</tr>
				<tr>
					<td>Disponible : </td>
					<td><label for="oui">Oui </label><input type="radio" name="disponible" value="true" id="oui"></td>
					<td><label for="non">Non </label><input type="radio" name="disponible" value="false" id="non"></td>
				</tr>
				<tr>
					<td colspan="3"><input type="submit" value="Créer"></td>
				</tr>
			</table>
		</form>
	</td></tr></table>
</body>
</html>
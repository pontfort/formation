<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<table>
	<tr>
		<td>Reference</td>
		<td>Nom</td>
		<td>Date d'achat</td>
	</tr>
	<c:forEach items="${equipements}" var="item">
		<tr>
			<td><c:out value="${item.reference}"></c:out></td>
			<td><c:out value="${item.nom}"></c:out></td>
			<td><c:out value="${item.dateAchat}"></c:out></td>
			<td><a href="/emergency/spring/equipement/${item.id}/delete">Supprimer</a></td>
		</tr>
	</c:forEach>
</table>

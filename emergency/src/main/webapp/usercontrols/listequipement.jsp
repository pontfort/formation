<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="com.formation.emergency.domain.pojo.Equipement,java.util.List"
	pageEncoding="ISO-8859-1"%>


<c:set var="aaa" value="${results}"></c:set>
<%-- 	<c:forEach items="${aaa}" var="e"> --%>
<%-- 	<c:forEach items="${requestScope.results}" var="e"> --%>
<c:forEach items="${pageScope.aaa}" var="e">
	<div>
		<c:out value="${e.reference}"></c:out>
		&nbsp&nbsp&nbsp&nbsp&nbsp <a href="delete?id=${e.id}">Supprimer</a>
	</div>
</c:forEach>
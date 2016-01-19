<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<c:choose>
	<c:when test="${sessionScope.connected}">
		<form method="post" action="logout">			
			<input type="submit" value="Logout">
		</form>
	</c:when>
</c:choose>

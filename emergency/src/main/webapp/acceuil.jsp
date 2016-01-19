<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/usercontrols/menu.jsp"></jsp:include>
	<%
		String action = (String) request.getParameter("action");
		if (action != null && action.equals("logout")) {
			request.getSession().setAttribute("loggedin", false);
			request.getSession().invalidate();
		}
	%>

	<c:choose>
		<c:when test="${loggedin}">
		You are already logged-in
	</c:when>

		<c:otherwise>
			<form method="post" action="login">
				<div>
					Username: <input type="text" name="username" required="required">
				</div>
				<div>
					Password: <input type="password" name="password"
						required="required">
				</div>
				<input type="submit" value="Log-In">
			</form>
		</c:otherwise>
	</c:choose>



</body>
</html>
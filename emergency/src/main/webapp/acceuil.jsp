<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page de connexion</title>
</head>
<body>
<jsp:include page="/menu.jsp"></jsp:include>
	<form action="login" method="post">
		<div>Login : <input type="text" name="login" autocomplete="off" required></div>
		<div>Password : <input type="password" name="pwd" required></div>
		<input type="submit" value="Login">
	</form>
</body>
</html>
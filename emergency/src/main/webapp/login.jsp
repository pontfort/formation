<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form method="get" action="login">
		<div>
			Login : <input type="text" name="login" required="champ requis" >
		</div>		
		<div>
			Mot de passe : <input type="password" name="motDePasse" required="champ requis">
		</div>
		<div>
			<input type="submit" value="valider">
		</div>
	</form>

</body>
</html>
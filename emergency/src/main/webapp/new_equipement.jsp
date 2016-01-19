<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Equipements</title>
</head>
<body>

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
			<input type="submit" value="valider">
		</div>

	</form>

</body>
</html>
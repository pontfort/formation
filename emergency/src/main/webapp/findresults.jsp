
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
import="com.formation.emergency.domain.pojo.Equipement,java.util.List"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% 
	List<Equipement> eqs=(List<Equipement>)request.getAttribute("results");
	for(Equipement e : eqs){
		%>
		<div><%=e.getReference() %>&nbsp&nbsp&nbsp&nbsp&nbsp<a href="delete?id=<%=e.getId()%>">Supprimer</a></div>
		<%  
	}
	%>
</body>
</html>
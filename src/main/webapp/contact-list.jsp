<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Manager - Contact List</title>
</head>
<body>
<form method = "post" action = "nagivationServlet">
	<table>
	<c:forEach items = "${requestScope.allContacts}" var = "currentcontact">
		<tr>
			<td><input type = "radio" name = "id" value = "${currentcontact.id}"></td>
			<td>${currentcontact.name}</td>
			<td>${currentcontact.email}</td>
			<td>${currentcontact.phoneNumber}</td>
		</tr>
	</c:forEach>
	</table>
<input type = "submit" value = "edit" name = "doThisToContact">
<input type = "submit" value = "delete" name = "doThisToContact">
<input type = "submit" value = "add" name = "doThisToContact">
</form>
</body>
</html>
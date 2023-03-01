<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Manager - Edit Contact</title>
</head>
<body>
	<form action = "editContactServlet" method = "post">
		Name: <input type ="text" name = "name" value = "${contactToEdit.name}"> <br />
		Email: <input type = "text" name = "email" value = "${contactToEdit.email}"> <br />
		Phone #: <input type = "text" name = "phone" value = "${contactToEdit.phoneNumber}"> <br />
		<input type = "hidden" name = "id" value = "${contactToEdit.id}">
		<input type = "submit" value = "Save Contact">
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact Manager - Create New List</title>
</head>
<body>
	<form action = "createNewListServlet" method = "post">
		List Name: <input type = "text" name = "listName"><br />
		Date Added: <input type = "text" name = "month" placeholder = "mm" size = "4"> 
		<input type = "text" name = "day" placeholder = "dd" size = "4">
		<input type = "text" name = "year" placeholder = "yyyy" size = "4">
		Manager Name: <input type = "text" name = "managerName">
		<br />
		Available Contacts:<br />
		<select name = "allContactsToAdd" multiple size = "6">
			<c:forEach items = "${requestScope.allContacts}" var = "currentcontact">
				<option value = "${currentcontact.id}">${currentcontact.name} | ${currentcontact.email} | ${currentcontact.phoneNumber}</option>
			</c:forEach>
		</select>
		<br />
		<input type = "submit" value = "Create List & Add Contacts">
	</form>
	<a href = "index.html">Add New Contacts</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact Manager - Manager Lists</title>
</head>
<body>
	<form method = "post" action = "listNavigationServlet">
		<table>
			<c:forEach items="${requestScope.allLists}" var="currentlist">
				<tr>
					<td><input type="radio" name="id" value="${currentlist.id}"></td>
					<td><h2>${currentlist.managerListName}</h2></td>
				</tr>
				<tr>
					<td colspan="3">Date Added: ${currentlist.dateAdded}</td>
				</tr>
				<tr>
					<td colspan="3">Manager: ${currentlist.manager.managerName}</td>
				</tr>
				<c:forEach var = "listVal" items = "${currentlist.listOfContacts}">
				<tr><td></td>
					<td colspan="3">${listVal.name}, ${listVal.email}, ${listVal.phoneNumber}</td></tr>
				</c:forEach>
			</c:forEach>
		</table>
		<input type = "submit" value = "edit" name = "doThisToList">
		<input type = "submit" value = "delete" name = "doThisToList">
		<input type = "submit" value = "add" name = "doThisToList">
	</form>
	<a href = "addContactsForListServlet">Create New Manager List</a> <br />
	<a href = "index.html">Insert New Contact</a>
</body>
</html>
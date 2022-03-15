<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Book</title>
</head>
<body>
<h1>All Book </h1>
<table>
	<tr> 
		<td>ID</td>
		<td>Title</td>
		<td>Language</td>
		<td>Pages</td>
	</tr>
	<c:forEach var="book" items="${books}">
		<tr>
        <td><c:out value="${book.id}"></c:out></td>
        <td><c:out value="${book.title}"></c:out></td>
        <td><c:out value="${book.language}"></c:out></td>
        <td><c:out value="${book.numberOfPages}"></c:out></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
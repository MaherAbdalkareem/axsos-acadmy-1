<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<title>Welcome</title>
</head>
<body class="container">
	<div class="row">
		<div class="col">
		<h1>Welcome <c:out value="${thisUser.userName}"></c:out>!</h1>
		</div>
		<div class="col">
		<p> <a href="/logout">LogOut</a> </p>
		</div>
	</div>
	<div class="row">
		<div class="col">
		<p>Books from everyone's shelves</p>
		</div>
		<div class="col">
		<a href="/books/new">+ Add a to my shelf</a>
		</div>
	</div>
	<table class="table table-dark table-striped">
		<thead>
			<tr>
				<td>ID</td>
				<td>Title</td>
				<td>Author Name</td>
				<td>Posted By</td>
			</tr>
		</thead>
		<tbody>
			 <c:forEach var="book" items="${books}">
			 		<tr>
       			 <td><c:out value="${book.id}"></c:out></td>
       			 <td><a href="/books/${book.id}"><c:out value="${book.title}"></c:out></a></td>
       			 <td><c:out value="${book.author}"></c:out> </td>
       			 <td><c:out value="${book.user.userName}"></c:out> </td>
       			 </tr>
    		</c:forEach>
		</tbody>
	</table>
</body>
</html>
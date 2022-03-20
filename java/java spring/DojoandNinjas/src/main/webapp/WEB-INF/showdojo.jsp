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
<title>Show Dojo</title>
</head>
<body class="container">
<h1><c:out value="${myDojo.name}"></c:out>'s Ninjas</h1>
	<table class="table table-dark table-striped">
		<thead>
			<tr>
				<td>First Name</td>
				<td>Last Name</td>
				<td>Age</td>
			</tr>
		</thead>
		<tbody>
			 <c:forEach var="ninja" items="${myDojo.ninjas}">
			 		<tr>
       			 <td><c:out value="${ninja.firstName}"></c:out></td>
       			 <td><c:out value="${ninja.lastName}"></c:out></td>
       			 <td><c:out value="${ninja.age}"></c:out> </td>
       			 </tr>
    		</c:forEach>
		</tbody>
	</table>
</body>
</html>
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
		<h1>Namaste, <c:out value="${thisUser.userName}"></c:out>!</h1>
	</div>
	<div class="col">
		<a href="/logout">Logout</a>
	</div>
	</div>
	<div class="row">
	<p>Course Schedule</p>
	</div>
	<table class="table table-dark table-striped">
		<thead>
			<tr>
				<td>Class Name</td>
				<td>Instructor</td>
				<td>Weekday</td>
				<td>Price</td>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="course" items="${courses}">
		
			 		<tr>
			 		<c:choose>
			 		<c:when test="${ course.user.userName == thisUser.userName}">
       			 <td><a href="/classes/${course.id}"><c:out value="${course.userName}"></c:out></a><a href="/classes/${course.id}/edit" class="btn btn-primary">Edit</a></td>
       			 </c:when>
       			 <c:otherwise>
       			 <td><a href="/classes/${course.id}"><c:out value="${course.userName}"></c:out></a></td>
       			 </c:otherwise>
       			 </c:choose>
       			 <td><c:out value="${course.user.userName}"></c:out></td>
       			 <td><c:out value="${course.day}"></c:out> </td>
       			 <td><c:out value="${course.price}"></c:out></td>
       			 </tr>
       			
    		</c:forEach>
		</tbody>
	</table>
	<div class="row">
	<div class="col">
			<a href="/classes/new" class="btn btn-primary">+ New Course</a>
		</div>
	</div>
</body>
</html>
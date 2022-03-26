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
			<h1>Welcome <c:out value="${user.firstName}"></c:out>!</h1>
		</div>
		<div class="col">
			<a href="/logout">Logout</a>
		</div>
	</div>
	<div class="row">
		<div class="col">
			<p>All Projects</p>
		</div>
		<div class="col">
			<a href="/projects/new" class="btn btn-primary">+ New Project</a>
		</div>
	</div>
	<table class="table table-dark table-striped">
		<thead>
			<tr>
				<td>Project</td>
				<td>Team Lead</td>
				<td>Due Date</td>
				<td>Action</td>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="project" items="${projects}">
		
			 		<tr>
       			 <td><a href="/projects/${project.id}"><c:out value="${project.title}"></c:out></a></td>
       			 <td><c:out value="${project.user.firstName}"></c:out></td>
       			 <td><c:out value="${project.date}"></c:out> </td>
       			 <td><a href="/join/${project.id }">Join Team</a></td>
       			 </tr>
       			
    		</c:forEach>
		</tbody>
	</table>
	<div class="row">
		<div class="col">
			<p>Your Projects</p>
		</div>
	</div>
	<table class="table table-dark table-striped">
		<thead>
			<tr>
				<td>Project</td>
				<td>Team Lead</td>
				<td>Due Date</td>
				<td>Action</td>
			</tr>
		</thead>
		<tbody>
		<c:if test="${ user.myProjects.size()>0}">
		<c:forEach var="project" items="${user.myProjects}">
		
			 		<tr>
       			 <td><a href="/projects/${project.id}"><c:out value="${project.title}"></c:out></a></td>
       			 <td><c:out value="${project.user.firstName}"></c:out></td>
       			 <td><c:out value="${project.date}"></c:out> </td>
       			 <c:choose>
       			 <c:when test="${ project.user.firstName == user.firstName}">
       			 <td><a href="/edit/${project.id }">Edit</a></td>
       			 </c:when>
       			 <c:otherwise>
       			 	 <td><a href="/leave/${project.id }">Leave Team</a></td>
       			 </c:otherwise>
       			 </c:choose>
       			 </tr>
       			
    		</c:forEach>
    		 </c:if>
		</tbody>
	</table>
</body>
</html>
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
<title>Read Book</title>
</head>
<body class="container">
	<div class="row">
    <div class="col">
     <h1><c:out value="${book.title}"></c:out> </h1>
    </div>
    <div class="col">
    <a href="/books">back to the shelves</a>
    </div>
    </div>
    <c:choose>
    <c:when test="${book.user.id != user.id }">
    <div class="row">
    <div class="col">
     <p><c:out value="${book.user.userName}"></c:out> read <c:out value="${book.title}"></c:out> By <c:out value="${book.author}"></c:out></p>
    </div>
    </div>
    <div class="row">
    <div class="col">
     <h2>Here Are <c:out value="${book.user.userName}"></c:out>'s Thoughts </h2>
    </div>
    </div>
    </c:when>
    <c:otherwise>
    <div class="row">
    <div class="col">
     <p>You read <c:out value="${book.title}"></c:out> By <c:out value="${book.author}"></c:out></p>
    </div>
    </div>
    <div class="row">
    <div class="col">
     <h2>Here Are Your Thoughts </h2>
    </div>
    </div>
    </c:otherwise>
    </c:choose>
    <div class="row">
    <div class="col">
     <p><c:out value="${book.myThoughts}"></c:out> </p>
    </div>
    </div>
    <c:if test="${book.user.id == user.id }">
     <a href="/books/${book.id }/edit" class="btn btn-primary">Edit</a>
    </c:if>
</body>
</html>
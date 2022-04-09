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
<title>Insert title here</title>
</head>
<body class="container">
	<div class="row">
    <div class="col">
     <h1><c:out value="${course.userName }"></c:out> with <c:out value="${course.user.userName }"></c:out></h1>
    </div>
    </div>
    <p>Day : <c:out value="${course.day }"></c:out> </p>
    <p>Cost : <c:out value="${course.price }"></c:out> </p>
    <p>Description: <c:out value="${course.description }"></c:out> </p>
     <a href="/classes" class="btn btn-primary">Back To Classes</a>
</body>
</html>
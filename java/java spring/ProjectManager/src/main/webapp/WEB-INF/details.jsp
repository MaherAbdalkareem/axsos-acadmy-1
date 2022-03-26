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
<title>Details </title>
</head>
<body class="container">
	<div class="row">
    <div class="col">
     <h1> Project Details</h1>
    </div>
    <div class="col">
    <a href="/dashboord">Back To Dashboord</a>
    </div>
    </div>
	<div class="row">
	<div class="col-auto">
  <div class="row">
    <label   class="col-form-label">Project Title </label>
  </div>
  <div class="row">
   	<label   class="col-form-label"><c:out value="${project.title }"></c:out></label>
  </div>
  <div class="row">
    <label   class="col-form-label">Project Description </label>
  </div>
  <div class="row">
    <label   class="col-form-label"><c:out value="${project.description }"></c:out></label>
  </div>
  <div class="row">
    <label   class="col-form-label">Project Date </label>
  </div>
  <form:errors path="date"/>
  <div class="row">
   	 <label   class="col-form-label"><c:out value="${project.date }"></c:out></label>
  </div>
  </div>
  </div>
  <div class="row">
  <div class="col">
  	<a href="/projects/${project.id }/tasks">See Tasks</a>
  </div>
  </div>

</body>
</html>
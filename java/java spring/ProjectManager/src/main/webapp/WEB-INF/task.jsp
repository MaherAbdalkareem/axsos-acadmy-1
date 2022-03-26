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
<title>Task</title>
</head>
<body class="container">
	<div class="row">
    <div class="col">
     <h1> Project : <c:out value="${project.title }"></c:out></h1>
    </div>
    <div class="col">
    <p>this project lead by <c:out value="${project.user.firstName }"></c:out></p>
    </div>
    </div>

	<form:form action="/new/task" method="post" modelAttribute="newTask">
	<div class="row">
	<div class="col-auto">
  <div class="row">
    <form:label path="task"  class="col-form-label">Add a Task for this team </form:label>
  </div>
  <form:errors path="task"/>
  <div class="row">
    <form:input path="task"  class="form-control" aria-describedby="titleHelpInline"/>
  </div>
  </div>
  </div>
  <div class="row">
  <div class="col">
  <button type="submit" class="btn btn-primary">Submit</button>
  </div>
  <div class="col">
  <a href="/dashboord" class="btn btn-primary">Cancel</a>
  </div>
  </div>
  </form:form>
</body>
</html>
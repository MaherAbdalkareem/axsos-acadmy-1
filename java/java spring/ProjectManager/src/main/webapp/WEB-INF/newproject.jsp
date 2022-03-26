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
<title>New Project</title>
</head>
<body class="container">
	<div class="row">
    <div class="col">
     <h1>Create Project</h1>
    </div>
    </div>
	<form:form action="/new/project" method="post" modelAttribute="newProject">
	<div class="row">
	<div class="col-auto">
  <div class="row">
    <form:label path="title"  class="col-form-label">Project Title </form:label>
  </div>
  <form:errors path="title"/>
  <div class="row">
    <form:input path="title"  class="form-control" aria-describedby="titleHelpInline"/>
  </div>
  <div class="row">
    <form:label path="description"  class="col-form-label">Project Description </form:label>
  </div>
  <form:errors path="description"/>
  <div class="row">
    <form:textarea path="description"  class="form-control" aria-describedby="authorHelpInline"/>
  </div>
  <div class="row">
    <form:label path="date"  class="col-form-label">Project Date </form:label>
  </div>
  <form:errors path="date"/>
  <div class="row">
    <form:input path="date" type="date" class="form-control" aria-describedby="myThoughtsHelpInline"/>
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
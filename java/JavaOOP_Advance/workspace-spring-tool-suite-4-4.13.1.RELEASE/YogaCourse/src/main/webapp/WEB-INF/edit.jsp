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
     <h1><c:out value="${course.userName }"></c:out></h1>
    </div>
    </div>
	<form:form action="/edit/${course.id }" method="post" modelAttribute="course">
	<div class="row">
	<div class="col-auto">
  <div class="row">
    <form:label path="userName"  class="col-form-label">Name </form:label>
  </div>
  <form:errors path="userName"/>
  <div class="row">
    <form:input path="userName"  class="form-control" aria-describedby="titleHelpInline"/>
  </div>
  <div class="row">
    <form:label path="day"  class="col-form-label">Day of Week </form:label>
  </div>
  <form:errors path="day"/>
  <div class="row">
    <form:input path="day"  class="form-control" aria-describedby="authorHelpInline"/>
  </div>
  <div class="row">
    <form:label path="price"  class="col-form-label">Drpo-in Price </form:label>
  </div>
  <form:errors path="price"/>
  <div class="row">
    <form:input path="price"  class="form-control" aria-describedby="myThoughtsHelpInline"/>
  </div>
  <div class="row">
  <div class="row">
    <form:label path="description"  class="col-form-label">Description </form:label>
  </div>
  <form:errors path="description"/>
  <div class="row">
    <form:textarea path="description"  class="form-control" aria-describedby="myThoughtsHelpInline"/>
  </div>
  </div>
  </div>
  <div class="row">
  <div class="col">
  <button type="submit" class="btn btn-primary">Submit</button>
  </div>
  <div class="col">
  <a href="/classes" class="btn btn-primary">Cancel</a>
  </div>
  <div class="col">
  <a href="/classes/delete/${course.id }" class="btn btn-primary">Delete</a>
  </div>
  </div>
  </form:form>

</body>
</html>
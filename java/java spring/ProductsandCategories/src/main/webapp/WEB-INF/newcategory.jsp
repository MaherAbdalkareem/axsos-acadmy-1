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
<title>New Category</title>
</head>
<body  class="container">
	<div class="row">
    <div class="col">
     <h1>New Category</h1>
    </div>
    </div>
	<form:form action="/new/category" method="post" modelAttribute="category">
	<div class="row">
	<div class="col-auto">
  <div class="row">
    <form:label path="name"  class="col-form-label">Name </form:label>
  </div>
  <form:errors path="name"/>
  <div class="row">
    <form:input path="name"  class="form-control" aria-describedby="nameHelpInline"/>
  </div>
  </div>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
  </form:form>
  

</body>
</html>
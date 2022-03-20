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
<title>New Dojo</title>
</head>
<body class="container">
	<div class="row">
    <div class="col">
     <h1>New Dojo</h1>
    </div>
    </div>
	<form:form action="/new/dojo" method="post" modelAttribute="dojo">
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
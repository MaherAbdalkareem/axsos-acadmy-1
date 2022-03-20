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
<title>New Product</title>
</head>
<body class="container">
	<div class="row">
    <div class="col">
     <h1>New Product</h1>
    </div>
    </div>
	<form:form action="/new/product" method="post" modelAttribute="product">
	<div class="row">
	<div class="col-auto">
  <div class="row">
    <form:label path="name"  class="col-form-label">Name </form:label>
  </div>
  <form:errors path="name"/>
  <div class="row">
    <form:input path="name"  class="form-control" aria-describedby="nameHelpInline"/>
  </div>
  <div class="row">
    <form:label path="description"  class="col-form-label">Description </form:label>
  </div>
  <form:errors path="description"/>
  <div class="row">
    <form:textarea path="description"  class="form-control" aria-describedby="descriptionHelpInline"/>
  </div>
  <div class="row">
    <form:label path="price"  class="col-form-label">Price </form:label>
  </div>
  <form:errors path="price"/>
  <div class="row">
    <form:input path="price"  class="form-control" aria-describedby="nameHelpInline"/>
  </div>
  </div>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
  </form:form>

</body>
</html>
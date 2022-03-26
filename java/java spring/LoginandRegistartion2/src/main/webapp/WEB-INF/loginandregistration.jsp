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
<title>Login & Registration</title>
</head>
<body class="container">
<h1>Welcome</h1>
<p>Join our growing community</p>
<div class="row">
	<div class="col">
		<h2>Registration</h2>
		<form:form action="/registration" method="post"  modelAttribute="newUser">
	<div class="row">
	<div class="col-auto">
  <div class="row">
    <form:label path="userName"  class="col-form-label">User Name </form:label>
  </div>
  <form:errors path="userName"/>
  <div class="row">
    <form:input path="userName"  class="form-control" aria-describedby="nameHelpInline"/>
  </div>
  <div class="row">
    <form:label path="email"  class="col-form-label">Email </form:label>
  </div>
  <form:errors path="email"/>
  <div class="row">
    <form:input path="email"  class="form-control" aria-describedby="emailHelpInline"/>
  </div>
  <div class="row">
    <form:label path="password"  class="col-form-label">Password </form:label>
  </div>
  <form:errors path="password"/>
  <div class="row">
    <form:input path="password" type="password" class="form-control" aria-describedby="passwordHelpInline"/>
  </div>
  <div class="row">
    <form:label path="confirmPW"  class="col-form-label">Confirm Password </form:label>
  </div>
  <form:errors path="confirmPW"/>
  <div class="row">
    <form:input path="confirmPW" type="password" class="form-control" aria-describedby="confirmPWHelpInline"/>
  </div>
  </div>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
  </form:form>
	</div>
	<div class="col">
		<h3>Login</h3>
		<form:form action="/login" method="post"  modelAttribute="newLogin">
	<div class="row">
	<div class="col-auto">
  <div class="row">
    <form:label path="email"  class="col-form-label">Email </form:label>
  </div>
  <form:errors path="email"/>
  <div class="row">
    <form:input path="email"  class="form-control" aria-describedby="emailHelpInline"/>
  </div>
  <div class="row">
    <form:label path="password"  class="col-form-label">Password </form:label>
  </div>
  <form:errors path="password"/>
  <div class="row">
    <form:input path="password"  class="form-control" aria-describedby="passwordHelpInline"/>
  </div>
  </div>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
  </form:form>
	</div>
	</div>
</body>
</html>
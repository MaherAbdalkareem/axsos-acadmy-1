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
<title>New Ninja</title>
</head>
<body class="container">
	<div class="row">
    <div class="col">
     <h1>New Ninja</h1>
    </div>
    </div>
	<form:form action="/new/ninja" method="post" modelAttribute="ninja">
	<div class="row">
	<div class="col-auto">
  <div class="row">
  <form:label path="dojo"  class="col-form-label">Dojos </form:label>
    <form:select path="dojo"  class="col-form-label"> 
     <c:forEach var="dojo" items="${dojos}">
     <option value="${dojo.id }">${dojo.name}</option>
     </c:forEach>
     </form:select>
  </div>
  <form:errors path="dojo"/>
   <div class="row">
    <form:label path="firstName"  class="col-form-label">First Name </form:label>
  </div>
  <form:errors path="firstName"/>
  <div class="row">
    <form:input path="firstName"  class="form-control" aria-describedby="firstNameHelpInline"/>
  </div>
   <div class="row">
    <form:label path="lastName"  class="col-form-label">Last Name </form:label>
  </div>
  <form:errors path="lastName"/>
  <div class="row">
    <form:input path="lastName"  class="form-control" aria-describedby="lastNameHelpInline"/>
  </div>
   <div class="row">
    <form:label path="age"  class="col-form-label">Age </form:label>
  </div>
  <form:errors path="age"/>
  <div class="row">
    <form:input path="age"  class="form-control" aria-describedby="titleHelpInline"/>
  </div>
  </div>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
  </form:form>

</body>
</html>
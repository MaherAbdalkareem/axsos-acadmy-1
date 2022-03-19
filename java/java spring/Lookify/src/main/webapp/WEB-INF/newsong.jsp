<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>New Song</title>
</head>
<body class="container">
<div class="row">
    <div class="col">
      <a href="/dashbord">Dashbord</a>
    </div>
    </div>
	<form:form action="/new" method="post" modelAttribute="song">
	<div class="row">
	<div class="col-auto">
  <div class="row">
    <form:label path="title"  class="col-form-label">Title </form:label>
  </div>
  <form:errors path="title"/>
  <div class="row">
    <form:input path="title"  class="form-control" aria-describedby="titleHelpInline"/>
  </div>
  <div class="row">
    <form:label path="artist"  class="col-form-label">Artist </form:label>
  </div>
  <form:errors path="artist"/>
  <div class="row">
    <form:input path="artist"  class="form-control" aria-describedby="artistHelpInline"/>
  </div>
  <div class="row">
    <form:label path="rating" for="rating" class="col-form-label">Rating (1-10) </form:label>
  </div>
  <form:errors path="rating"/>
  <div class="row">
    <form:input path="rating"  min="1" max="10" class="form-control" aria-describedby="ratingHelpInline"/>
  </div>
  </div>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
  </form:form>
</body>
</html>
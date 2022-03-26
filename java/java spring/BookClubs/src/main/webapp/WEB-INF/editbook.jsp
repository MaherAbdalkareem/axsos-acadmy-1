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
<title>Edit Book</title>
</head>
<body class="container">
	<div class="row">
    <div class="col">
     <h1>Change Your Entry</h1>
    </div>
    <div class="col">
    <a href="/books">back to the shelves</a>
    </div>
    </div>
	<form:form action="/edit/${editBook.id }" method="post" modelAttribute="editBook">
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
    <form:label path="author"  class="col-form-label">Author </form:label>
  </div>
  <form:errors path="author"/>
  <div class="row">
    <form:input path="author"  class="form-control" aria-describedby="authorHelpInline"/>
  </div>
  <div class="row">
    <form:label path="myThoughts"  class="col-form-label">My Thoughts </form:label>
  </div>
  <form:errors path="myThoughts"/>
  <div class="row">
    <form:textarea path="myThoughts"  class="form-control" aria-describedby="myThoughtsHelpInline"/>
  </div>
  </div>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
  </form:form>
	
</body>
</html>
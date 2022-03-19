<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Details</title>
</head>
<body class="container">
<div class="row">
    <div class="col">
      <a href="/dashbord">Dashbord</a>
    </div>
    </div>
 <div class="row">
    <div class="col">
      Title
    </div>
    <div class="col">
      <c:out value="${mySong.title}"></c:out>
    </div> 
  </div>
  <div class="row">
    <div class="col">
      Artist
    </div>
    <div class="col">
      <c:out value="${mySong.artist}"></c:out>
    </div> 
  </div>
  <div class="row">
    <div class="col">
      Rating(1-10)
    </div>
    <div class="col">
      <c:out value="${mySong.rating}"></c:out>
    </div> 
  </div>
</body>
</html>
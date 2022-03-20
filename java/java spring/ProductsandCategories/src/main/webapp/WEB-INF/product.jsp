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
<title>Products</title>
</head>
<body class="container">
<h1><c:out value="${product.name}"></c:out></h1>
	<p> Categories:
	<ul class="list-group">
	 <c:forEach var="category" items="${categoryBelong}">
		  <li class="list-group-item"><c:out value="${category.name}"></c:out></li>
		  </c:forEach>
		</ul> 
	 </p>
	<form action="/new/category/${product.id }" method="post" >
	<div class="row">
	<div class="col-auto">
  <div class="row">
  <label class="col-form-label">categories </label>
    <select name="categories"  class="col-form-label"> 
     <c:forEach var="category" items="${categoryNotBelong}">
     <option value="${category.id }">${category.name}</option>
     </c:forEach>
     </select>
  </div>
</div>
</div>
 <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>
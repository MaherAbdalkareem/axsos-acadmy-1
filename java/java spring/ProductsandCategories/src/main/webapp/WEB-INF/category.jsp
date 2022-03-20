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
<title>Categories</title>
</head>
<body class="container">
<h1><c:out value="${category.name}"></c:out></h1>
	<p> Products:
	<ul class="list-group">
	 <c:forEach var="product" items="${productBelong}">
		  <li class="list-group-item"><c:out value="${product.name}"></c:out></li>
		  </c:forEach>
		</ul> 
	 </p>
	<form action="/new/product/${category.id }" method="post" >
	<div class="row">
	<div class="col-auto">
  <div class="row">
  <label class="col-form-label">products </label>
    <select name="products"  class="col-form-label"> 
     <c:forEach var="product" items="${productNotBelong}">
     <option value="${product.id }">${product.name}</option>
     </c:forEach>
     </select>
  </div>
</div>
</div>
 <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>
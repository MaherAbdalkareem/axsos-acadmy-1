<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
<h1>Fruit Store</h1>
<table  class="table table-dark table-sm">
<tr >
<td>Name</td>
<td>Price</td>
</tr>
<c:forEach var="fruits" items="${myFruits }">
<tr>
<td><c:out value="${fruits.name }" ></c:out></td>
<td><c:out value="${fruits.price }" ></c:out></td>
</tr>
</c:forEach>
</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import= "java.time.format.DateTimeFormatter" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Time</title>
<script type="text/javascript" src="js/app.js"></script>
<link rel="stylesheet" type="text/css" href="/css/time.css">
</head>
<body>
<h1> <c:out value="${time}"/></h1>
</body>
</html>
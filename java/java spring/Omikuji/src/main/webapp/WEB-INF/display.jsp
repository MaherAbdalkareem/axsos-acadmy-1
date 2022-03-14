<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Omikuji</title>
</head>
<body>
<h1>Here's Your Omikuji!</h1>
<p></p>In <c:out value="${myNumber }"></c:out> years,you will live in <c:out value="${city }"></c:out>
	with <c:out value="${person }"></c:out> as your roommate, <c:out value="${hoppy }"></c:out>
	for a living,the next time you see a <c:out value="${living }"></c:out>,you will have a good luck.
	Also, <c:out value="${desc }"></c:out>.</p>
	<div><a href="/">Go Back</a></div>
</body>
</html>
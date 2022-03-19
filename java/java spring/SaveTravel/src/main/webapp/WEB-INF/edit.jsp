<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Edit Expense</title>
</head>
<body class="container">
	<h1>Edit Expense</h1>
	<form:form action="/edit/${expense.id }" method="post" modelAttribute="expense" >
	<input type="hidden" name="_method" value="put">
		<p class="mb-3" >
			<form:label class="form-label" path="expenseName">Expense Name</form:label>
			<form:errors path="expenseName"></form:errors>
			<form:input class="form-control" path="expenseName"/>
		</p>
		<p class="mb-3">
			<form:label class="form-label" path="vendor">Vendor</form:label>
			<form:errors path="vendor"></form:errors>
			<form:input class="form-control" path="vendor"/>
		</p>
		<p class="mb-3">
			<form:label class="form-label"  path="amount">Amount</form:label>
			<form:errors path="amount"></form:errors>
			<form:input class="form-control" path="amount"/>
		</p>
		<p class="mb-3">
			<form:label class="form-label" path="description">Description</form:label>
			<form:errors path="description"></form:errors>
			<form:textarea class="form-control" path="description"/>
		</p>
		<button type="submit">Submit</button>
	</form:form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>Travel</title>
</head>
<body class="container">
<div class="row">
<h1 class="col">Save Travel</h1>
	
	<table class="table table-dark table-striped">
		<thead>
			<tr>
				<td>Expenses</td>
				<td>Vendor</td>
				<td>Amount</td>
				<td>Action</td>
			</tr>
		</thead>
		<tbody>
			 <c:forEach var="expense" items="${expenses}">
			 		<tr>
       			 <td><c:out value="${expense.expenseName}"></c:out></td>
       			 <td><c:out value="${expense.vendor}"></c:out></td>
       			 <td><c:out value="${expense.amount}"></c:out></td>
       			 <td><a href="/edit/${expense.id}">edit</a> <br> <form action="/delete/${expense.id}" method="post">
    																<input type="hidden" name="_method" value="delete">
   																	 <input type="submit" value="Delete">
																			</form></td>
       			 </tr>
    		</c:forEach>
		</tbody>
	</table>
	<form:form action="/expenses" method="post" modelAttribute="expense" >
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
	</div>
</body>
</html>
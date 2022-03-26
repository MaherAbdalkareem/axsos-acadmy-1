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
<title>Book Market</title>
</head>
<body class="container">
	<div class="row">
		<div class="col">
		<h2>Hello,<c:out value="${user.userName}"></c:out>. Welcome to ...</h2>
		</div>
		<div class="col">
		<p> <a href="/logout">LogOut</a> </p>
		</div>
	</div>
	<div class="row">
		<div class="col">
		<h1>The Book Broker!</h1>
		</div>
		 <div class="col">
    <a href="/books">back to the shelves</a>
    </div>
	</div>
	<div class="row">
		<div class="col">
		<p>Available Book To Borrow</p>
		</div>
		</div>
	<table class="table table-dark table-striped">
		<thead>
			<tr>
				<td>ID</td>
				<td>Title</td>
				<td>Author Name</td>
				<td>Posted By</td>
				<td>Action</td>
			</tr>
		</thead>
		<tbody>
			 <c:forEach var="book" items="${myBooks}">
			 		<tr>
       			 <td><c:out value="${book.id}"></c:out></td>
       			 <td><a href="/books/${book.id}"><c:out value="${book.title}"></c:out></a></td>
       			 <td><c:out value="${book.author}"></c:out> </td>
       			 <td><c:out value="${book.user.userName}"></c:out> </td>
       			 <c:choose>
       			 <c:when test="${user.id != book.user.id }">
       			 <td><a href="/borrow/${book.id }">borrow</a></td>
       			 </c:when>
       			 <c:otherwise>
       			 <td><a href="/books/${book.id}/edit">edit</a> <span><a href="/books/${book.id}/delete">delete</a></span></td>
       			 </c:otherwise>
       			 </c:choose>
       			 </tr>
    		</c:forEach>
		</tbody>
	</table>
	<div class="row">
		<div class="col">
		<p> Book I'm Borrowing...</p>
		</div>
		</div>
		<table class="table table-dark table-striped">
		<thead>
			<tr>
				<td>ID</td>
				<td>Title</td>
				<td>Author Name</td>
				<td>Posted By</td>
				<td>Action</td>
			</tr>
		</thead>
		<tbody>
		<c:if test="${user.borrowedBooks.size()>0  }">
			 <c:forEach var="book" items="${user.borrowedBooks}">
			 		<tr>
       			 <td><c:out value="${book.id}"></c:out></td>
       			 <td><a href="/books/${book.id}"><c:out value="${book.title}"></c:out></a></td>
       			 <td><c:out value="${book.author}"></c:out> </td>
       			 <td><c:out value="${book.user.userName}"></c:out> </td>
       			 <td><a href="/return/${book.id }">return</a></td>
       			 </tr>
    		</c:forEach>
    		</c:if>
		</tbody>
	</table>
</body>
</html>
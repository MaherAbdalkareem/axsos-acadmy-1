<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Top Ten</title>
</head>
<body class="container">
<div class="row">
    <div class="col">
      <a href="/dashbord">Dashbord</a>
    </div>
    </div>
	<h1>Top Ten Songs</h1>
	<table class="table table-dark table-striped">
		<thead>
			<tr>
				<td>Name</td>
				<td>Rating</td>
				<td>Action</td>
			</tr>
		</thead>
		<tbody>
			 <c:forEach var="song" items="${songs}">
			 		<tr>
       			 <td><c:out value="${song.title}"></c:out></td>
       			 <td><c:out value="${song.rating}"></c:out></td>
       			 <td> <form action="/delete/${song.id}" method="post">
    				<input type="hidden" name="_method" value="delete">
   					<input type="submit" value="Delete">
					</form></td>
       			 </tr>
    		</c:forEach>
		</tbody>
	</table>
</body>
</html>
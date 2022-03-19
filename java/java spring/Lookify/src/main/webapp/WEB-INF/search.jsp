<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="/songs/new">Add New</a>
    <a class="navbar-brand" href="/search/topten">Top Songs</a>
    <form action="/search" method="post"  class="d-flex">
      <input name="search" class="form-control me-2" type="search" placeholder="Search" aria-label="Search"/>
      <button class="btn btn-outline-success" type="submit">Search</button>
    </form>
  </div>
</nav>
<table class="table table-dark table-striped">
		<thead>
			<tr>
				<td>Name</td>
				<td>Rating</td>
				<td>Action</td>
			</tr>
		</thead>
		<tbody>
			 <c:forEach var="song" items="${mySong}">
			 		<tr>
       			 <td><a href="/songs/${song.id}"><c:out value="${song.title}"></c:out></a></td>
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
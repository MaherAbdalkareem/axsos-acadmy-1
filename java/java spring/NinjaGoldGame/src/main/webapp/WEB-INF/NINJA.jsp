<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ninja Gold</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="result"><p id="parg"> Your Gold : </p><p id="gold"> <c:out value="${myGold }"></c:out> </p></div>
    <div class="cont">
    <div class="box">
        <p>Farm</p>
        <p>(earns 10-20 golds)</p>
        <form action="/process_money" method="post">
            <input type="hidden" name="which_form" value="farm">
        <button type="submit">Find Gold</button>
        </form>
    </div>
    <div class="box">
        <p>cave</p>
        <p>(earns 10-20 golds)</p>
        <form action="/process_money" method="post">
            
            <input type="hidden" name="which_form" value="cave">
            <button type="submit">Find Gold</button>
        </form>
    </div>
    <div class="box">
        <p>House</p>
        <p>(earns 10-20 golds)</p>
        <form action="/process_money" method="post">
            
            <input type="hidden" name="which_form" value="house">
            <button type="submit">Find Gold</button>
        </form>
    </div>
    <div class="box">
        <p>Casino</p>
        <p>(earns/takes 0-50 golds)</p>
        <form action="/process_money" method="post">
           
            <input type="hidden" name="which_form" value="casino">
            <button type="submit">Find Gold</button>
        </form>
    </div>
    </div>
    <div>
    <p>Activities:</p> 
    <section>
       <c:forEach var="action" items="${myActivitie}">
        <p><c:out value="${action}"></c:out></p>
    </c:forEach>
       
    </section>
        
</div>
</body>
</html>

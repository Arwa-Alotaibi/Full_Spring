<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Login and Registration</title>

<style>
h1{

color:Purple;
}


</style>
</head>
<body>
<h1 >Welcome <c:out value="${user.username}" /> </h1>

<p> this is your dashboard Nothing to see here yet.</p>

<a href="/logout">logout</a>
</body>
</html>
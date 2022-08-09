<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
    
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Read Share</title>
</head>
<body>
<a href="/books">back to the shelves</a>

<h1><c:out value="${showbook.title }"></c:out></h1>

<p><span style="color:red">${showbook.user.username} </span> read <span style="color:purple">${showbook.title}</span> by <span style="color:green">${showbook.author}</span></p>

<h1>Here are ${showbook.user.username} thoughts </h1>
 
<hr/> 
  
 <p> ${showbook.thoughts }</p>
  
 <hr/>
 
 <button><a href="/books/${showbook.id}/edit">Edit</a></button>
</body>
</html>
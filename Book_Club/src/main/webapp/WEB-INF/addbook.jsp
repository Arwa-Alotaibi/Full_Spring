<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page isErrorPage="true" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Book share</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">

</head>
<body>
<h1>Add a book to your shelf</h1>

<a href="/books">back to the shelves</a>
<form:form action="/books/new" method="post" modelAttribute="book">

 <div class="form-group">
            <label>Title</label>
            <form:input path="title" class="form-control" />
            <form:errors path="title" class="text-danger" />
        </div>
        <div class="form-group">
            <label>Author:</label>
            <form:input path="author" class="form-control" />
            <form:errors path="author" class="text-danger" />
        </div>
        <div class="form-group">
            <label>thoughts:</label>
            <form:input path="thoughts" class="form-control" />
            <form:errors path="thoughts" class="text-danger" />
        </div>
        
        <input type="submit" value="submit" class="btn btn-primary" />


</form:form>

</body>
</html>
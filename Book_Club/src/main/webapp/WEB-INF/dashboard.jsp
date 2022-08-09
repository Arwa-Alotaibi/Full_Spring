<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Read Share</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<h1>Welcome , <c:out value="${user.username }"> </c:out></h1>
<p>Books from everyone's shelves  </p>

<a href="/logout">logout</a>
<a href="/books/new">+Add a to my sheif !</a>

<table class="table table-striped">
<tr>
<th>ID</th>

<th>Title</th>

<th>Author Name</th>

<th>Posted By</th>

</tr>
<c:forEach var="book" items="${Allbooks}">
<tr>
<td><c:out value="${book.id}"> </c:out></td>

<td><a href="/books/${book.id }"><c:out value="${book.title}"> </c:out> </a></td>

<td><c:out value="${book.author}"> </c:out> </td>

<td><c:out value="${book.user.username}"> </c:out> </td>


</tr>
</c:forEach>






</table>
</body>
</html>
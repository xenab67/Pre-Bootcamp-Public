<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Languages</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<nav>
<a href="/new">Create Language</a>
</nav>
<div class="container">
<h1>Languages</h1>
<table class="table table-dark">
	<thead>
		<td>Name</td>
		<td>Creator</td>
		<td>Version</td>
		<td>Action</td>
	</thead>
	<tbody>
	<c:forEach items="${languages}" var="language">
	<tr>
		<td><a href="/language/${language.id}">${language.name}</a></td>
		<td>${language.creator}</td>
		<td>${language.version}</td>
		<td><a href="/edit/${language.id}">edit</a></td>
		<td><a href="/delete/${language.id}">delete</a></td>
	</tr>
	</c:forEach>
	</tbody>
</table>
</div>
</body>
</html>
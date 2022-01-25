<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>
<nav>
<a href="/">Dashboard</a>
</nav>
<h1>${dojo.name}</h1>
<hr>
<h2>Ninjas</h2>
<table class="table table-dark">
	<thead>
		<td>First Name</td>
		<td>Last Name</td>
		<td>Age</td>
	</thead>
	<tbody>
	<c:forEach items="${dojo.ninjas}" var="ninja">
	<tr>
		<td>${ninja.firstName}</td>
		<td>${ninja.lastName}</td>
		<td>${ninja.age}</td>
	</tr>
	</c:forEach>
	</tbody>
</table>
</body>
</html>
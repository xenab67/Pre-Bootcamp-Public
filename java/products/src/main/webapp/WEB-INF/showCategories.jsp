<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Categories</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>
<nav>
<a href="/">Dashboard</a>
<a href="/">All Products</a>
</nav>
<h1>All Categories:</h1>
<table class="table table-dark">
	<thead>
		<td>Name</td>
	</thead>
	<tbody>
	<c:forEach items="${categories}" var="category">
	<tr>
		<td><a href="category/${category.id}">${category.name}</a></td>
	</tr>
	</c:forEach>
	</tbody>
</table>
</body>
</html>
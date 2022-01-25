<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>
<h1>Welcome, ${user.firstName} ${user.lastName}!</h1>
<nav>
<a href="/logout">
<button class="btn btn-outline-danger">Logout</button>
</a>
</nav>
<div class="container">
	<table class="table table-striped table-info ">
		<thead>
			<th>Name</th>
			<th>Created By:</th>
		</thead>
		<tbody>
			<c:forEach items="${allIdeas}" var="idea">
			<tr>
				<td><a href="/show/${idea.id}">${idea.name}</a></td>
				<td>${idea.owner.firstName} ${idea.owner.lastName }</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/new">
	<button class="btn btn-outline-success">Create an Idea</button>
	</a>
</div>
</body>
</html>
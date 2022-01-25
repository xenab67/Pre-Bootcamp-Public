<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>
<h1>Edit ${idea.name}</h1>
	<form:form method="POST" action="/edit/${idea.id}" modelAttribute="idea">
	<form:label path="name">Idea Name</form:label>
	<form:errors path="name"/>
	<form:input type="text" path="name"/>
	<button class="btn btn-outline-info">Update Idea</button>
	<a href="/delete/${idea.id}">
<button class="btn btn-outline-danger">Delete</button>
</a>
	</form:form>
</body>
</html>
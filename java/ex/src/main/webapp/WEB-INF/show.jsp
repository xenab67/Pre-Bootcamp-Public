<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Idea Details</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>
<div class="container">
<h1>${showIdea.name}</h1>
	<h2>Created By: ${showIdea.owner.firstName} ${showIdea.owner.lastName}</h2>
<a href="/edit/${showIdea.id}">
<button class="btn btn-outline-success">Edit</button>
</a>
<a href="/delete/${showIdea.id}">
<button class="btn btn-outline-danger">Delete</button>
</a>
</div>
</body>
</html>
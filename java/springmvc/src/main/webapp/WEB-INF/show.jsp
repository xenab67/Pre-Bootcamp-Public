<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Language Details</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container">
<nav>
<a href="/">Dashboard</a>
</nav>
<h1>Language Details</h1>
<hr>
<p>Name:${language.name}</p>
<p>Creator: ${language.creator}</p>
<p>Version: ${language.version}</p>
<a href="/edit/${language.id}">Edit</a>
<a href="/delete/${language.id}">Delete</a>
</div>
</body>
</html>